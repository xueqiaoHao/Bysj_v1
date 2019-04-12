package com.hao.employment.dao;

import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.ResumeSearchParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/3 17:41*/
@Mapper
@Component
public interface ResumeMapper {
    /*查看简历
    * 1、满足条件的总条数
    * 2、满足条件的详细简历信息数据
    * */
    @Select("<script> select count(1) from resume_info as stu " +" <where> " +
            "<if test=\"major != null and major != '' \"> AND stu.major=#{major}</if> " +
            "<if test=\"educationBack != null and educationBack != '' \"> AND stu.education_back=#{educationBack}</if> " +
            "<if test=\"isPublish != null and isPublish != '' \"> AND stu.is_publish=#{isPublish}</if> " +
            "<if test=\"deliveredCom != null and deliveredCom != '' \"> AND stu.delivered_com like CONCAT('%',#{deliveredCom},'%')</if> " +
            "</where> </script> ")
    long getResumeDataCount(ResumeSearchParams resumeSearchParams);
    @Select("<script> select * from resume_info as stu " +" <where> " +
            "<if test=\"major != null and major != '' \"> AND stu.major=#{major}</if> " +
            "<if test=\"educationBack != null and educationBack != '' \"> AND stu.education_back=#{educationBack}</if> " +
            "<if test=\"isPublish != null and isPublish != '' \"> AND stu.is_publish=#{isPublish}</if> " +
            "<if test=\"deliveredCom != null and deliveredCom != '' \"> AND stu.delivered_com like CONCAT('%',#{deliveredCom},'%')</if> " +
            "</where> limit #{offset},#{pageSize} </script> ")
    List<Resume> getResumeDataList(ResumeSearchParams resumeSearchParams);

    /*发布简历
    * 简历保存
    * 简历投递*/
}
