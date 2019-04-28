package com.hao.employment.bean.param;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/24 17:07*/
@Data
public class SearchParams {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer offset;
    public Integer getOffset() {
        return (this.pageNumber-1)*this.pageSize;
    }

}
