package com.hao.employment.dao;

import com.hao.employment.bean.entry.Recruitment;
import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.RecruitSearchParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jboss.logging.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/3 16:49*/
@Mapper
@Component
public interface RecruitMapper {

    /*
   该方法实现查看系统中所有的招聘信息
   * */
    @Select("<script> select count(1) from recruitment_info as com " +" <where> " +
            "<if test=\"major != null and major != '' \"> AND com.major=#{major}</if> " +
            "<if test=\"educationBack != null and educationBack != '' \"> AND com.education_back=#{educationBack}</if> " +
            "</where> </script> ")
    Long getRecruitmentDataCount(RecruitSearchParams recruitSearchParams);

    @Select("<script> select * from recruitment_info as com " +" <where> " +
            "<if test=\"major != null and major != '' \"> AND com.major=#{major}</if> " +
            "<if test=\"educationBack != null and educationBack != '' \"> AND com.education_back=#{educationBack}</if> " +
            "</where> limit #{offset},#{pageSize} </script> ")
    List<Recruitment> getRecruitmentDataList(RecruitSearchParams recruitSearchParams);

    /*发布招聘信息*/
    @Insert("<script> " +
            "insert into recruitment_info " +
            "(id,name,address,nature,type,publisher,depart,phone,info,major,education_back,people_nums,job_way,job_info,career_talk,talk_time,publish_time) " +
            "values " +
            "(null,#{name},#{address},#{nature},#{type},#{publisher},#{depart},#{phone},#{info},#{major},#{educationBack},#{peopleNums},#{jobWay},#{jobInfo},#{careerTalk},#{talkTime},#{publishTime}) " +
            "</script> ")
    void insertRecruitment(Recruitment recruitment);


}
