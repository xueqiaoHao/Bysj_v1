package com.hao.employment.web;


import com.hao.employment.bean.param.ResumeSearchParams;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*@author haoxueqiao
  @date 2019/3/28 19:14*/
/*简历
* 学生编写简历
* 公司、管理员查看简历
* */
@Slf4j
@Controller
@RequestMapping(value = "resume")
public class ResumeController {
    @Autowired
    ResumeService resumeService;
    /*查看简历
    * --简历在此被查看*/
    @ResponseBody
        @RequestMapping(value = "getResumeReport",method = RequestMethod.POST)
    public ResultPojo getResumeReport(@RequestBody ResumeSearchParams resumeSearchParams){
        log.info(resumeSearchParams.toString());
        ResultPojo resultDto=resumeService.getResumePageData(resumeSearchParams);
        return resultDto;
    }
    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "后端数据";
    }
}
