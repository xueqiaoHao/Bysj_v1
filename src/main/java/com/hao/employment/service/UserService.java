package com.hao.employment.service;

import com.hao.employment.bean.param.UserLoginParams;
import com.hao.employment.common.enums.ResultStatusEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/10 16:45*/
@Service
@Component
public interface UserService {
    List<String> getAllUserName();
    int loginValidate(UserLoginParams userLoginParams);
}
