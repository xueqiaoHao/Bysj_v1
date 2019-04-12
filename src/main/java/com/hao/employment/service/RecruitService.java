package com.hao.employment.service;

import com.hao.employment.bean.entry.Recruitment;
import com.hao.employment.bean.param.RecruitSearchParams;
import com.hao.employment.bean.pojo.ResultPojo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*@author haoxueqiao
  @date 2019/4/3 16:45*/
@Service
@Component
public interface RecruitService {
    /*招聘
    发布招聘信息
    查看招聘信息
    */
    void publishRecruitment(Recruitment recruitment);
    /*查看招聘信息*/
    ResultPojo getRecruitmentPageData(RecruitSearchParams recruitSearchParams);
}
