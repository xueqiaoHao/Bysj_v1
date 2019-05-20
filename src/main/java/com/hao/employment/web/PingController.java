package com.hao.employment.web;


import com.hao.employment.dao.UserMapper;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*@author haoxueqiao
  @date 2019/5/20 10:44*/
@Controller
public class PingController {
    @Autowired
    UserMapper userMapper;
    @ResponseBody
    @RequestMapping(value = "/")
    public List<String> pingController(){
        List<String> result=userMapper.getAllUserAccount();
        return result;
    }
}
