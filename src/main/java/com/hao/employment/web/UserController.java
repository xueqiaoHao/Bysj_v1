package com.hao.employment.web;

import com.hao.employment.bean.param.UserLoginParams;
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
    * 2、根据用户身份类拉取自己拥有的菜单*/
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public int login(@RequestBody  UserLoginParams userLoginParams){
        List<String> userNameList=userService.getAllUserName();
        if(userNameList.contains(userLoginParams.getUserName())){
        log.info(userLoginParams.toString());
        return userService.loginValidate(userLoginParams);
        }
        else {
            return 1;
        }
    }
}
