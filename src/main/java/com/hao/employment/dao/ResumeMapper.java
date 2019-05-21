package com.hao.employment.dao;

import com.hao.employment.bean.entry.Recruitment;
import com.hao.employment.bean.entry.Resume;
import com.hao.employment.bean.param.DeliverResumeParams;
import com.hao.employment.bean.param.ResumeSearchParams;
import com.hao.employment.bean.param.SignParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/*@author haoxueqiao
  @date 2019/4/3 17:41*/
@Mapper
@Component
public interface ResumeMapper {
    /*查看简历
    * 1、满足条件的总条数(包括管理员查看总数和单位查看已投递简历)
    * 2、满足条件的详细简历信息数据
    * */
    @Select("<script> select count(1) from resume_info as stu " +" <where> " +
            "<if test=\"major != null and major != '' \"> AND stu.major=#{major}</if> " +
            "<if test=\"educationBack != null and educationBack != '' \"> AND stu.education_back=#{educationBack}</if> " +
            "<if test=\"isPublic != null and isPublic != '' \"> AND stu.is_public=#{isPublic}</if> " +
            "<if test=\"deliveredCom != null and deliveredCom != '' \"> AND stu.delivered_com like CONCAT('%',#{deliveredCom},'%')</if> " +
            "</where> </script> ")
    long getResumeDataCount(ResumeSearchParams resumeSearchParams);
    @Select("<script> select * from resume_info as stu " +" <where> " +
            "<if test=\"major != null and major != '' \"> AND stu.major=#{major}</if> " +
            "<if test=\"educationBack != null and educationBack != '' \"> AND stu.education_back=#{educationBack}</if> " +
            "<if test=\"isPublic != null and isPublic != '' \"> AND stu.is_public=#{isPublic}</if> " +
            "<if test=\"deliveredCom != null and deliveredCom != '' \"> AND stu.delivered_com like CONCAT('%',#{deliveredCom},'%')</if> " +
            "</where> limit #{offset},#{pageSize} </script> ")
    List<Resume> getResumeDataList(ResumeSearchParams resumeSearchParams);

    /*发布简历
    * 简历保存
    * 简历投递*/
    @Insert("<script> " +
            "insert into resume_info " +
            "(id,name,age,sex,birth,major,depart,education_back,education_length," +
            "training_mode,origin,graduation_time,job_intention,languages,language_level,computer_level,phone,email,address,message,is_public,delivered_com,is_signed) " +
            "values " +
            "(null,#{name},#{age},#{sex},#{birth},#{major},#{depart},#{educationBack},#{educationLength},#{trainingMode},#{origin},#{graduationTime},#{jobIntention},#{languages},#{languageLevel},#{computerLevel},#{phone}, " +
            "#{email},#{address},#{message},#{isPublic},#{deliveredCom},#{isSigned}) " +
            "</script> ")
    void saveResume(Resume resume);


    /*计算签约率
    * 签约人数/总人数
    * */
    @Select("select count(1) from resume_info where is_signed=1")
    int getSignedNum();
    /*简历投递
    * 根据用户名去简历表中找此人的简历并将投递公司置为comName
    * 注意，他有投递过进简历和没有投递过简历语句是不一样的
    * 应该传入两个参数，userName和comName
    * UPDATE resume_info SET deliver_com=#{comName} WHERE name=#{userName}
    * */
    /*判断简历是否第一次向外投递*/
    @Select("select delivered_com from resume_info where name=#{userName}")
    String isDelivered(DeliverResumeParams deliverResumeParams);
    /*初次投递，之前并未投递公司*/
    @Update("UPDATE resume_info SET delivered_com=#{comName} WHERE name=#{userName}")
    void updateDeliverCom(DeliverResumeParams deliverResumeParams);

    /*之前有过投递其他家公司*/
    @Update("UPDATE resume_info SET delivered_com=CONCAT(delivered_com,',',#{comName}) WHERE name=#{userName}")
    void updateDeliverComAgain(DeliverResumeParams deliverResumeParams);

    /*更新签约进度*/
    @Update("UPDATE resume_info set is_signed=#{isSigned} where name=#{stuName}")
    void updateIsSigned(SignParams signParams);
}
