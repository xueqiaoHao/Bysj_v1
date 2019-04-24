package com.hao.employment.service.Impl;

import com.hao.employment.dao.UserMapper;
import com.hao.employment.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*@author haoxueqiao
  @date 2019/4/17 16:23*/
@Service
@Component
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String getUserRole(String userAccount) {
        log.info(userAccount);
        return userMapper.getUserIdentity(userAccount);
    }
}
