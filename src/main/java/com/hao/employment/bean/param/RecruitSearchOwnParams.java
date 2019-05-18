package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/5/11 12:42*/
@Data
public class RecruitSearchOwnParams {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer offset;
    /*查询招聘信息的传递进来的参数*/
    private String comName;
    public Integer getOffset() {
        return (this.pageNumber-1)*this.pageSize;
    }
}