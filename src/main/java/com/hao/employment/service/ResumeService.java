package com.hao.employment.service;

import com.hao.employment.bean.param.ResumeSearchParams;
import com.hao.employment.bean.pojo.ResultPojo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*@author haoxueqiao
  @date 2019/4/3 16:46*/
@Service
@Component
public interface ResumeService {
    /*简历
    发布简历
    查看简历
    * */


    /*查看简历*/
    ResultPojo getResumePageData(ResumeSearchParams resumeSearchParams);
}
