package com.hao.employment.dao;

import com.hao.employment.bean.entry.SysMenu;
import com.hao.employment.bean.entry.SysUser;
import com.hao.employment.bean.param.UserLoginParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/10 16:48*/
@Mapper
@Component
public interface UserMapper {
    /*登陆验证*/
    @Select("select account from sys_user")
    List<String> getAllUserAccount();
    /*有用户名拿密码*/
    @Select("<script> select password from sys_user " +" <where> " +
            "<if test=\"userName != null and userName != '' \"> AND user_name=#{userName}</if> " +
            "</where> </script>")
    String loginValidate(UserLoginParams userLoginParams);

    /*获取用户身份类型*/
    @Select("<script> select user_role from sys_user " +" <where> " +
            "<if test=\"_parameter != null and _parameter != '' \"> AND user_name=#{userName}</if> " +
            "</where> </script>")
    String getUserIdentity(String userName);

    /*拿到账号去找用户实体*/
    @Select("<script> select * from sys_user where account=#{userAccount} </script>")
    SysUser getUserEntityByAccount(String userAccount);
    /*根据userId去拿menuList
    *
    * (1)根据user_account去拿user_id  调上面的方法然后.getUserId
    * (2)通过拿到的user_id去拿role_id select role_id from sys_user_role where user_id= (1)         sys_user_role
    * (3)通过role_id去拿menu_id  select menu_id from sys_role_menu where role_id=                 sys_role_menu
    * (4)通过menu_id去表里面取出来menu实体 select menu from sys_menu where id=                       sys_menu
    * */
    @Select("<script> select m.* from sys_menu m,sys_role_menu rm,sys_user_role ur " +
            "where m.id=rm.menu_id and rm.role_id=ur.role_id and ur.user_id=#{userId}" +
            " </script>")
    List<SysMenu> getUserMenuListByAccount(Integer userId);

    /*通过所有的菜单Id取拿所有的父级菜单*/
    @Select("<script> select m.* from sys_menu m " +
            "where m.id in (#{menuIds})" +
            " </script>")
    List<SysMenu> getParentMenuList(String menuIds);

}
