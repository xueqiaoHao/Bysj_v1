package com.hao.employment.service.Impl;

import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.ResumeSearchParams;
import com.hao.employment.bean.pojo.PageDataPojo;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.enums.ResultStatusEnum;
import com.hao.employment.dao.ResumeMapper;
import com.hao.employment.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/3 16:48*/
@Service
@Component
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    ResumeMapper resumeMapper;
    @Override
    public  ResultPojo getResumePageData(ResumeSearchParams resumeSearchParams){
        long total=resumeMapper.getResumeDataCount(resumeSearchParams);
        List<Resume> resumeList=resumeMapper.getResumeDataList(resumeSearchParams);
        PageDataPojo pageDataPojo=new PageDataPojo();
        pageDataPojo.setPageSize(resumeSearchParams.getPageSize());
        pageDataPojo.setPageNumber(resumeSearchParams.getPageNumber());
        pageDataPojo.setTotal(total);
        pageDataPojo.setDataList(resumeList);
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        resultPojo.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        resultPojo.setData(pageDataPojo);
        return resultPojo;
    };
}
