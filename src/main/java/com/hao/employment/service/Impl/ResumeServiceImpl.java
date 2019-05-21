package com.hao.employment.service.Impl;

import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.DeliverResumeParams;
import com.hao.employment.bean.param.ResumeSearchParams;
import com.hao.employment.bean.param.SignParams;
import com.hao.employment.bean.pojo.PageDataPojo;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.enums.ResultStatusEnum;
import com.hao.employment.common.util.DataHandleUtil;
import com.hao.employment.dao.ResumeMapper;
import com.hao.employment.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/*@author haoxueqiao
  @date 2019/4/3 16:48*/
@Service
@Component
@Slf4j
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    ResumeMapper resumeMapper;

    @Override
    public ResultPojo saveResume(Resume resume) {
        ResultPojo resultPojo=new ResultPojo();
        resumeMapper.saveResume(resume);
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        return resultPojo;
    }

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
    }

    @Override
    public ResultPojo getSignedPercent(ResumeSearchParams resumeSearchParams) {
        int total= ((int) resumeMapper.getResumeDataCount(resumeSearchParams));
        int signedNum=resumeMapper.getSignedNum();
        Double result=DataHandleUtil.divisionInt(signedNum,total);
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setData(result);
        return resultPojo;
    }

    @Override
    public ResultPojo deliverResume(DeliverResumeParams deliverResumeParams) {
        /*先判断是否是初次投递*/
        String deliveredCom=resumeMapper.isDelivered(deliverResumeParams);
        log.info("已投递公司总览:"+deliveredCom);
        if(deliveredCom==null||deliveredCom.trim().length()==0||deliveredCom==""){
            resumeMapper.updateDeliverCom(deliverResumeParams);
        }else {
            resumeMapper.updateDeliverComAgain(deliverResumeParams);
        }

        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        resultPojo.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        return resultPojo;
    }

    @Override
    public ResultPojo setSign(SignParams signParams) {
        ResultPojo resultPojo=new ResultPojo();
        resumeMapper.updateIsSigned(signParams);
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        return resultPojo;
    }

    ;
}
