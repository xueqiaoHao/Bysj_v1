package com.hao.employment.bean.pojo;

import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/3 17:33*/
@Data
public class PageDataPojo {
    private Integer pageSize;
    private Integer pageNumber;
    private Long total;
    private Object dataList;
}
