package com.hao.employment.service.Impl;

import com.hao.employment.bean.param.UserLoginParams;
import com.hao.employment.common.enums.ResultStatusEnum;
import com.hao.employment.dao.UserMapper;
import com.hao.employment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public List<String> getAllUserName() {
        return userMapper.getAllUserName();
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
}
