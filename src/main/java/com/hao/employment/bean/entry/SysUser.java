package com.hao.employment.bean.entry;

import lombok.Data;

import javax.persistence.*;

/*@author haoxueqiao
  @date 2019/4/18 14:01*/
@Data
@Table(name = "sys_user")
public class SysUser {
    /*
    id
    */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*
    * 姓名
    * */
    @Column(name = "user_name")
    private String userName;

    /*
    * 账号
    * */
    @Column(name = "account")
    private String account;

    /*
    * 密码
    * */
    @Column(name = "password")
    private String password;
    /*
    * 邮箱
    * */
    @Column(name = "email")
    private String email;
}
