package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/5/12 9:59*/
@Data
public class UserSelfRole {
    int userId;
    int role;

    @Override
    public String toString() {
        return "UserSelfRole{" +
                "id=" + userId +
                ", role=" + role +
                '}';
    }
}
