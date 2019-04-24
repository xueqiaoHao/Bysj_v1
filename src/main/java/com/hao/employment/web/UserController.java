package com.hao.employment.web;

import com.hao.employment.bean.entry.SysMenu;
import com.hao.employment.bean.entry.SysUser;
import com.hao.employment.bean.param.UserLoginParams;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.enums.ResultStatusEnum;
import com.hao.employment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/10 16:37*/
@Slf4j
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;
    /*1、供用户登陆校验和注册
    * 2、由账号拿用户名，放在页面显示
    * 3、根据用户身份类拉取自己拥有的菜单*/
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResultPojo login(@RequestBody  UserLoginParams userLoginParams){
      return userService.login(userLoginParams);
    }

    @ResponseBody
    @RequestMapping(value = "curUserName")
    public ResultPojo getUserName(@RequestBody UserLoginParams userLoginParams){
        log.info("用户账号："+userLoginParams.getLoginAccount());
        SysUser sysUser=userService.getUserEntityByLoginAccount(userLoginParams.getLoginAccount());
        log.info("用户名为："+sysUser.getUserName());
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        resultPojo.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        resultPojo.setData(sysUser.getUserName());
        return resultPojo;
    }

    @ResponseBody
    @RequestMapping(value = "curUserMenuList")
    public ResultPojo getUserSysMenu(@RequestBody UserLoginParams userLoginParams){
    // 传进来的loginAccount去找去找name和id。然后找role，然后通过role去找menu
        List<SysMenu> sysMenuList=userService.gerCurUserMenuList(userLoginParams.getLoginAccount());
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        resultPojo.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        resultPojo.setData(sysMenuList);
        return resultPojo;
    }
}
