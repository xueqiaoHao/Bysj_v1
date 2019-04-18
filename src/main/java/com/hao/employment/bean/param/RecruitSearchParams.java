package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/7 21:15*/
@Data
public class RecruitSearchParams {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer offset;
    /*查询招聘信息的传递进来的参数*/
    /*薪资待遇*/
    private String salary;
    /*安照专业*/
    private String major;
    /*学历*/
    private String educationBack;
    public Integer getOffset() {
        return (this.pageNumber-1)*this.pageSize;
    }
}
