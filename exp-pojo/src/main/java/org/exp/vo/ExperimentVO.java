package org.exp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

public class ExperimentVO {

    /**
     * 自增id
     */
    private Integer expId;
    /**
     * 实验名称
     */
    private String expName;

    /**
     * 实验课程
     */
    private String courseName;


    /**
     * 实验名称
     */
    private String expLocation;

    /**
     * 实验时间
     */
    private String expTime;
    /**
     * 实验负责人
     */
    private String expTeacher;

    /**
     * 实验文件地址
     */
    private String expFileUrl;

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getExpLocation() {
        return expLocation;
    }

    public void setExpLocation(String expLocation) {
        this.expLocation = expLocation;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    public String getExpTeacher() {
        return expTeacher;
    }

    public void setExpTeacher(String expTeacher) {
        this.expTeacher = expTeacher;
    }

    public String getExpFileUrl() {
        return expFileUrl;
    }

    public void setExpFileUrl(String expFileUrl) {
        this.expFileUrl = expFileUrl;
    }
}
