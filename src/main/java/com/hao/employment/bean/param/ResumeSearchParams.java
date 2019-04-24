package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/3 17:31*/
@Data
public class ResumeSearchParams {
    private String currentUserAccount;
    private String currentUserName;
    private String currentUserRole;
    private Integer pageSize;
    private Integer pageNumber;
    private Integer offset;
    /*安照专业*/
    private String major;
    /*学历*/
    private String educationBack;
    /*是否公开*/
    private int isPublic;
    //在前端把投递公司的这个值设定成userName
    /*投递公司*/
    private String deliveredCom;
    public Integer getOffset() {
        return (this.pageNumber-1)*this.pageSize;
    }

    @Override
    public String toString() {
        return "ResumeSearchParams{" +
                "currentUserAccount='" + currentUserAccount + '\'' +
                ", currentUserName='" + currentUserName + '\'' +
                ", currentUserRole='" + currentUserRole + '\'' +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", offset=" + offset +
                ", major='" + major + '\'' +
                ", educationBack='" + educationBack + '\'' +
                ", isPublic=" + isPublic +
                ", deliveredCom='" + deliveredCom + '\'' +
                '}';
    }
}
