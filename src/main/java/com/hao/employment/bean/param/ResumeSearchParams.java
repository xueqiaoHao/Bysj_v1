package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/3 17:31*/
@Data
public class ResumeSearchParams {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer offset;
    /*安照专业*/
    private String major;
    /*学历*/
    private String educationBack;
    /*是否公开*/
    private int isPublish;
    /*投递公司*/
    private String deliveredCom;
    public Integer getOffset() {
        return (this.pageNumber-1)*this.pageSize;
    }

    @Override
    public String toString() {
        return "ResumeSearchParams{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", offset=" + offset +
                ", major='" + major + '\'' +
                ", educationBack='" + educationBack + '\'' +
                ", isPublish=" + isPublish +
                ", deliveredCom='" + deliveredCom + '\'' +
                '}';
    }
}
