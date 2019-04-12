package com.hao.employment.dao;

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
    @Select("select user_name from sys_user")
    List<String> getAllUserName();
    @Select("<script> select password from sys_user " +" <where> " +
            "<if test=\"userName != null and userName != '' \"> AND user_name=#{userName}</if> " +
            "</where> </script>")
    String loginValidate(UserLoginParams userLoginParams);
}
