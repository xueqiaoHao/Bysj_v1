package com.hao.employment.service.Impl;

import com.hao.employment.bean.entry.SysMenu;
import com.hao.employment.bean.entry.SysUser;
import com.hao.employment.bean.param.UserLoginParams;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.enums.ResultStatusEnum;
import com.hao.employment.dao.UserMapper;
import com.hao.employment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*@author haoxueqiao
  @date 2019/4/10 16:47*/
@Slf4j
@Service
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ResultPojo login(UserLoginParams userLoginParams) {
        List<String> userAccountList=getAllUserAccount();
        ResultPojo resultPojo=new ResultPojo();
        if(userAccountList.contains(userLoginParams.getLoginAccount())){
            log.info(userLoginParams.toString());
            resultPojo.setStatus(loginValidate(userLoginParams));
            return resultPojo;
        }
        else {
            return resultPojo;
        }
    }

    @Override
    public List<String> getAllUserAccount() {
        return userMapper.getAllUserAccount();
    }

    @Override
    public int loginValidate(UserLoginParams userLoginParams) {
        String pass=userMapper.loginValidate(userLoginParams);
        log.info(pass);
        if (pass.equals(userLoginParams.getPassword())){
            return ResultStatusEnum.SUCCESS.getCode();
        }

        return ResultStatusEnum.ERROR.getCode();
    }

    @Override
    public SysUser getUserEntityByLoginAccount(String account) {
        return userMapper.getUserEntityByAccount(account);
    }

    @Override
    public List<SysMenu> gerCurUserMenuList(String loginAccount) {
        //通过账号拿到userId
        Integer userId=getUserEntityByLoginAccount(loginAccount).getId();
        log.info("userId"+userId.toString());
        //拿到所有的菜单
        List<SysMenu> sysMenuList=userMapper.getUserMenuListByAccount(userId);
        //判断出其中的父菜单
        List<SysMenu> parentMenuList=getParentMenu(sysMenuList);
        List<SysMenu> childMenuList=getChildMenu(sysMenuList);

        // 填充成为一个二层循环的集合
        List<SysMenu> resultMenuList=new ArrayList<SysMenu>();

        for (SysMenu parentMenu:parentMenuList
             ) {
            List<SysMenu> tempList=new ArrayList<SysMenu>();
            for (SysMenu childMenu:childMenuList
                 ) {
                if (parentMenu.getId()== childMenu.getParentId()){
                    tempList.add(childMenu);
                }
            }
            parentMenu.setChildren(tempList);
            resultMenuList.add(parentMenu);
        }
                
        return resultMenuList;
    }

    public  static List<SysMenu> getParentMenu(List<SysMenu> sysMenuList){
        List<SysMenu> parentMenuList=new ArrayList<SysMenu>();
        for (SysMenu menu:sysMenuList
                ) {
            if (menu.getParentId()==1){
                parentMenuList.add(menu);
            }
        }
        return parentMenuList;
    }
    public  static List<SysMenu> getChildMenu(List<SysMenu> sysMenuList){
        List<SysMenu> childMenuList=new ArrayList<SysMenu>();
        for (SysMenu menu:sysMenuList
                ) {
            if (menu.getParentId()!=1 && menu.getParentId()!=0){
                childMenuList.add(menu);
            }
        }
        return childMenuList;
    }
}
