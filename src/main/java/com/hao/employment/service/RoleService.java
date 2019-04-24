package com.hao.employment.service;

import org.springframework.stereotype.Service;

/*@author haoxueqiao
  @date 2019/4/17 16:18*/
@Service
public interface RoleService {
    //根据用户账号拿到此用户名对应的user_role
    String getUserRole(String userAccount);
}
