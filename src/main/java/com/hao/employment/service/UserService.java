package com.hao.employment.service;

import com.hao.employment.bean.entry.SysMenu;
import com.hao.employment.bean.entry.SysUser;
import com.hao.employment.bean.param.SearchParams;
import com.hao.employment.bean.param.UserLoginParams;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.enums.ResultStatusEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/10 16:45*/
@Service
@Component
public interface UserService {
    ResultPojo login(UserLoginParams userLoginParams);
    List<String> getAllUserAccount();
    int loginValidate(UserLoginParams userLoginParams);
    SysUser getUserEntityByLoginAccount(String loginAccount);
    List<SysMenu> gerCurUserMenuList(String loginAccount);
    ResultPojo getAccountList(SearchParams searchParams);
    void addUserEntity(SysUser sysUser);
    void deleteUserEntity(SysUser sysUser);
}
