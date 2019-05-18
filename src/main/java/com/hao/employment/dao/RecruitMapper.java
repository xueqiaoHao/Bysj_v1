package com.hao.employment.dao;

import com.hao.employment.bean.entry.Recruitment;
import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.RecruitSearchOwnParams;
import com.hao.employment.bean.param.RecruitSearchParams;
import com.hao.employment.bean.pojo.RecruitEvePojo;
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

    @Select("<script> select count(1) from recruitment_info as com " +" <where> " +
            "name=#{comName}"+
            "</where> </script> ")
    Long getRecruitmentOwnDataCount(RecruitSearchOwnParams recruitSearchOwnParams);

    @Select("<script> select * from recruitment_info as com " +" <where> " +
            "name=#{comName}"+
            "</where> limit #{offset},#{pageSize} </script> ")
    List<Recruitment> getRecruitmentOwnDataList(RecruitSearchOwnParams recruitSearchOwnParams);


    /*发布招聘信息*/
    @Insert("<script> " +
            "insert into recruitment_info " +
            "(id,name,address,nature,type,publisher,depart,phone,info,major,education_back,people_nums,job_way,job_info,career_talk,talk_time,publish_time) " +
            "values " +
            "(null,#{name},#{address},#{nature},#{type},#{publisher},#{depart},#{phone},#{info},#{major},#{educationBack},#{peopleNums},#{jobWay},#{jobInfo},#{careerTalk},#{talkTime},#{publishTime}) " +
            "</script> ")
    void insertRecruitment(Recruitment recruitment);

    /*查看招聘信息的统计结果
    * (1)拿出所有专业的招聘人数排行，包括专业名和招收人数
    * (2)拿出所有的薪资待遇的统计排行
    *   (3)查看git
    * */
    @Select("<script>SELECT sum(people_nums) as `value`, major `name` " +
            "from recruitment_info GROUP BY major " +
            "ORDER BY `value` desc " +
            "</script> ")
    List<RecruitEvePojo> getEveNumbersByMajor();
    @Select("<script> SELECT sum(people_nums) FROM recruitment_info"+
            "</script> ")
    int getAllRecruitNumbers();
}
