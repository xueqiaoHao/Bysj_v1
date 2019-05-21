package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/5/21 11:20*/
@Data
public class SignParams {
    String stuName;
    Integer isSigned;

    @Override
    public String toString() {
        return "SignParams{" +
                "stuName='" + stuName + '\'' +
                ", isSigned=" + isSigned +
                '}';
    }
}
