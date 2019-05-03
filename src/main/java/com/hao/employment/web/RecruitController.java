package com.hao.employment.web;


import com.hao.employment.bean.entry.Recruitment;
import com.hao.employment.bean.param.RecruitSearchParams;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.common.util.DateUtil;
import com.hao.employment.service.RecruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.rmi.CORBA.Util;
import java.util.Date;

/*@author haoxueqiao
  @date 2019/3/28 19:14*/
/*
* 招聘
* 公司发布招聘信息
* 学生、管理员查看招聘信息
* 管理员查看招聘信息统计结果报告
* */
@Slf4j
@Controller
@RequestMapping(value = "recruit")
public class RecruitController {
    @Autowired
    RecruitService recruitService;

    /*
    功能一：发布招聘*/
    @ResponseBody
    @RequestMapping(value = "publishRecruitment",method = RequestMethod.POST)
    public String publishRecruit(@RequestBody Recruitment recruitment){
        recruitment.setPublishTime(DateUtil.getCurrentTimeByString());
        recruitService.publishRecruitment(recruitment);
        return "招聘信息发布成功";
    }

    /*
    * 功能二：查看招聘信息*/
    @ResponseBody
    @RequestMapping(value = "getRecruitment",method = RequestMethod.POST)
    public ResultPojo getRecruitment(@RequestBody RecruitSearchParams recruitSearchParams){
        ResultPojo resultDto=recruitService.getRecruitmentPageData(recruitSearchParams);
        return resultDto;
    }

    /*
    * 功能三：管理员查看招聘信息分析报告
    * 按照常理应该是什么都不用传，直接去后端查然后拿结果数据就行
    * */
    @ResponseBody
    @RequestMapping(value = "getRecruitmentAnalyse",method = RequestMethod.POST)
    public ResultPojo getRecruitmentAnalyse(){
        log.info("请求分析数据getRecruitmentAnalyse");
        ResultPojo resultPojo=recruitService.getRecruitmentAnalyse();
        return resultPojo;
    }
}
