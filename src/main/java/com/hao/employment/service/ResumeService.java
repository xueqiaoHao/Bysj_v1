package com.hao.employment.service;

import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.DeliverResumeParams;
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
    ResultPojo saveResume(Resume resume);

    /*查看简历*/
    ResultPojo getResumePageData(ResumeSearchParams resumeSearchParams);

    /*查看签约率*/
    ResultPojo getSignedPercent(ResumeSearchParams resumeSearchParams);
    /*投递简历*/
    ResultPojo deliverResume(DeliverResumeParams deliverResumeParams);
}
