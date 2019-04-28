package com.hao.employment.dao;

import com.hao.employment.bean.entry.SysMenu;
import com.hao.employment.bean.entry.SysUser;
import com.hao.employment.bean.param.SearchParams;
import com.hao.employment.bean.param.UserLoginParams;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
    /*有登录账户拿密码*/
    @Select("<script> select password from sys_user " +" <where> " +
            "<if test=\"loginAccount != null and loginAccount != '' \"> AND account=#{loginAccount}</if> " +
            "</where> </script>")
    String loginValidate(UserLoginParams userLoginParams);

    /*获取用户身份类型
    * (1)由account去拿user_id
    * (2)由user_id去user_role里拿role_id
    * */
    @Select("<script> select ur.role_id from sys_user u,sys_user_role ur " +
            "where u.id=ur.user_id and  u.account=#{userAccount} " +
            " </script>")
    String getUserIdentity(String userAccount);

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
            "where m.id=rm.menu_id and rm.role_id=ur.role_id and ur.user_id=#{userId} " +
            " </script>")
    List<SysMenu> getUserMenuListByAccount(Integer userId);

    /*拿到所有的账号表数据*/
    @Select("<script> select * from sys_user limit #{offset},#{pageSize} " +
            " </script>")
    List<SysUser> getAccountList(SearchParams searchParams);

    @Select("<script> select count(1) from sys_user </script>")
    Long getAccountNum();

    /*新建用户
    * 1、用户名
    * 2、账号名
    * 3、密码
    * 4、身份类型
    * */
    @Insert("insert into sys_user (user_name,account,password,email) values (" +
            "#{userName}, #{account}, #{password}, #{email})")
    void addUser(SysUser sysUser);
    /*删除用户*/
    @Delete("delete from sys_user where id= #{id}")
    void deleteUser(SysUser sysUser);
}
