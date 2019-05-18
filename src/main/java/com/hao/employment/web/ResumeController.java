package com.hao.employment.web;


import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.DeliverResumeParams;
import com.hao.employment.bean.param.ResumeSearchParams;
import com.hao.employment.bean.pojo.ResultPojo;
import com.hao.employment.dao.UserMapper;
import com.hao.employment.service.ResumeService;
import com.hao.employment.service.RoleService;
import com.hao.employment.service.UserService;
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
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    /*查看简历
    * --简历在此被查看
    * 服务两种人，管理员和公司，若是公司就把public指定为1
    * */
    @ResponseBody
        @RequestMapping(value = "getResumeReport",method = RequestMethod.POST)
    public ResultPojo getResumeReport(@RequestBody ResumeSearchParams resumeSearchParams){
        log.info(resumeSearchParams.toString());
        if(resumeSearchParams.getCurrentUserAccount().toString()==null || (resumeSearchParams.getCurrentUserAccount().toString().trim().length()==0)){
            ResultPojo resultDto=new ResultPojo();
            String error="请输入账号";
            resultDto.setMessage(error);
            return resultDto;
        }
        resumeSearchParams.setCurrentUserRole(roleService.getUserRole(resumeSearchParams.getCurrentUserAccount().toString()));
        log.info("赋予角色后"+resumeSearchParams.toString());
        if(resumeSearchParams.getCurrentUserRole().equals("3")){
            //设定投递公司为登录的账号对应的用户名
            resumeSearchParams.setIsPublic(1);
            /*
            * 先拿实体再拿用户名
            * */
        }
        ResultPojo resultDto=resumeService.getResumePageData(resumeSearchParams);
        return resultDto;
    }
    @ResponseBody
    @RequestMapping(value = "getDeliveredResume",method = RequestMethod.POST)
    public ResultPojo getDeliveredResume(@RequestBody ResumeSearchParams resumeSearchParams){
        String curUserName=userService.getUserEntityByLoginAccount(resumeSearchParams.getCurrentUserAccount()).getUserName();
        resumeSearchParams.setDeliveredCom(curUserName);
        ResultPojo resultDto=resumeService.getResumePageData(resumeSearchParams);
        return resultDto;
    }

    /*查看签约率*/
    @ResponseBody
    @RequestMapping(value = "getSignedNum",method = RequestMethod.POST)
    public ResultPojo getSignedNum(@RequestBody ResumeSearchParams resumeSearchParams){
        log.info(resumeSearchParams.toString());
        ResultPojo resultDto=resumeService.getSignedPercent(resumeSearchParams);
        return resultDto;
    }
    /*新建并存储简历*/
    @ResponseBody
    @RequestMapping(value = "saveResume",method = RequestMethod.POST)
    public ResultPojo saveResume(@RequestBody Resume resume){
        log.info(resume.toString());
        ResultPojo resultPojo=resumeService.saveResume(resume);
        return resultPojo;
    }
    /*简历投递
    * 将对应公司的名字写入deliveredCom
    * */
    @ResponseBody
    @RequestMapping(value = "deliverResume",method = RequestMethod.POST)
    public ResultPojo deliverResume(@RequestBody DeliverResumeParams deliverResumeParams){
        log.info(deliverResumeParams.toString());
//        根据用户名去表里查对应的那条简历
        ResultPojo resultDto=resumeService.deliverResume(deliverResumeParams);
        return resultDto;
    }
}
