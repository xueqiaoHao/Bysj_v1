package com.hao.employment.bean.entry;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/*@author haoxueqiao
  @date 2019/4/18 14:01*/
@Data
@Table(name = "sys_menu")
public class SysMenu {
    /*
    * 菜单id
    * */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*
    *此menu的父id
    * */
    @Column(name = "parent_id")
    private int parentId;
    /*
    * 想要让这个menu渲染出来的话，它需要的所有顶层id
    * */
    @Column(name = "parent_ids")
    private String parentIds;
    /*
    * 菜单名儿
    * */
    @Column(name = "name")
    private String name;
    /*
    * 此菜单对应的前端路由路径
    * */
    @Column(name = "href")
    private String href;

    /*
    * 此菜单属于第几层
    * */
    @Column(name = "level")
    private int level;

    /*
    * sort  展示的时候按照这个排序然后在展示
    * */
    @Column(name = "sort")
    private int sort;

    List<SysMenu> children;
}
