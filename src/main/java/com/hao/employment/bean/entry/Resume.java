package com.hao.employment.bean.entry;

import lombok.Data;

import javax.persistence.*;

/*@author haoxueqiao
  @date 2019/4/3 17:09*/
@Data
@Table(name = "resume_info")
public class Resume {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String age;
    private String sex;
    //                   Date birth;
    private String birth;
    private String nation;
    @Column(name = "politics_status")
    private String politicsStatus;
    private String major;
    private String depart;
    @Column(name = "education_back")
    private String educationBack;
    @Column(name = "education_length")
    private String educationLength;
    @Column(name = "training_mode")
    private String trainingMode;
    private String origin;
    //                   Date graduation_time;
    @Column(name = "graduation_time")
    private String graduationTime;
    @Column(name = "job_intention")
    private String jobIntention;
    private String languages;
    @Column(name = "language_level")
    private String languageLevel;
    @Column(name = "computer_level")
    private String computerLevel;
    private String phone;
    private String email;
    private String address;
    private String message;
    @Column(name = "is_publish")
    private Integer isPublish;
    @Column(name = "delivered_com")
    private String deliveredCom;
    @Column(name = "is_signed")
    private Integer isSigned;
}
