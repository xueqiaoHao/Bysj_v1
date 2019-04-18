package com.hao.employment.bean.entry;

import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

/*@author haoxueqiao
  @date 2019/4/18 14:01*/
@Data
@Table(name = "sys_role")
public class SysRole {
    /*
    * 角色id
    * */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*
    * 角色名称
    * */
    @Column(name="name")
    private String name;
}
