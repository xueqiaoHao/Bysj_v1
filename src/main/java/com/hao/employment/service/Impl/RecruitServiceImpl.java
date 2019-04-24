package com.hao.employment.service.Impl;

import com.hao.employment.bean.entry.Recruitment;
import com.hao.employment.bean.param.RecruitSearchParams;
import com.hao.employment.bean.pojo.PageDataPojo;
import com.hao.employment.bean.pojo.RecruitEvePojo;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.enums.ResultStatusEnum;
import com.hao.employment.common.util.DataHandleUtil;
import com.hao.employment.dao.RecruitMapper;
import com.hao.employment.service.RecruitService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

/*@author haoxueqiao
  @date 2019/4/7 21:20*/
@Component
@Service
@Slf4j
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    RecruitMapper recruitMapper;
    /*发布招聘信息*/
    @Override
    public void publishRecruitment(Recruitment recruitment) {
        log.info(recruitment.toString());
        recruitMapper.insertRecruitment(recruitment);
    }

    /*查看招聘信息*/
    @Override
    public ResultPojo getRecruitmentPageData(RecruitSearchParams recruitSearchParams) {
        Long total=recruitMapper.getRecruitmentDataCount(recruitSearchParams);
        List<Recruitment> recruitmentList=recruitMapper.getRecruitmentDataList(recruitSearchParams);
        PageDataPojo pageDataPojo=new PageDataPojo();
        pageDataPojo.setPageSize(recruitSearchParams.getPageSize());
        pageDataPojo.setPageNumber(recruitSearchParams.getPageNumber());
        pageDataPojo.setTotal(total);
        pageDataPojo.setDataList(recruitmentList);
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        resultPojo.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        resultPojo.setData(pageDataPojo);
        return resultPojo;
    }

    /*就业招聘信息分析报告
    * 查出来每一门有多少的人数需求
    * 拿出来总的招收人数
    * 最后要返回的是计算结果和状态信息
    * */
    @Override
    public ResultPojo getRecruitmentAnalyse() {
        List<RecruitEvePojo> recruitEvePojoList=recruitMapper.getEveNumbersByMajor();
//        int total=recruitMapper.getAllRecruitNumbers();
        ResultPojo resultPojo=new ResultPojo();
//        List<RecruitEvePojo> resultPercentList=new ArrayList<RecruitEvePojo>();
//        /*
//        * 我需要做的是把每一门的都拿出来去除以这个total
//        * */
//        for (RecruitEvePojo recruitEvePojo:recruitEvePojoList
//             ) {
//        String resultPercent= DataHandleUtil.division(recruitEvePojo.getNum(),total);
//        recruitEvePojo.setPercent(resultPercent);
//        resultPercentList.add(recruitEvePojo);
//        }
        resultPojo.setStatus(ResultStatusEnum.SUCCESS.getCode());
        resultPojo.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        resultPojo.setData(recruitEvePojoList);
        return resultPojo;
    }
}
