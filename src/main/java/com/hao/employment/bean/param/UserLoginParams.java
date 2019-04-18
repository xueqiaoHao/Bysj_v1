package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/10 16:39*/
@Data
public class UserLoginParams {
    String loginAccount;
    String password;

    @Override
    public String toString() {
        return "UserLoginParams{" +
                "loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
