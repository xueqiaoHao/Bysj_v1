package com.hao.employment.bean.entry;

import lombok.Data;

import javax.persistence.*;

/*@author haoxueqiao
  @date 2019/4/3 17:09*/
@Data
@Table(name = "recruitment_info")
public class Recruitment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String  address;
    private String  nature;
    private String  type;
    private String  publisher;
    private String  depart;
    private String  phone;
    private String  info;
    private String  major;
    @Column(name = "education_back")
    private String  educationBack;
    @Column(name = "people_nums")
    private String  peopleNums;
    @Column(name = "job_way")
    private String  jobWay;
    @Column(name = "job_info")
    private String  jobInfo;
    @Column(name = "career_talk")
    private String  careerTalk;
    @Column(name = "talk_time")
    private String  talkTime;
    @Column(name = "publish_time")

    private String  publishTime;

    @Override
    public String toString() {
        return "Recruitment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nature='" + nature + '\'' +
                ", type='" + type + '\'' +
                ", publisher='" + publisher + '\'' +
                ", depart='" + depart + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", major='" + major + '\'' +
                ", educationBack='" + educationBack + '\'' +
                ", peopleNums='" + peopleNums + '\'' +
                ", jobWay='" + jobWay + '\'' +
                ", jobInfo='" + jobInfo + '\'' +
                ", careerTalk='" + careerTalk + '\'' +
                ", talkTime='" + talkTime + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }
}
