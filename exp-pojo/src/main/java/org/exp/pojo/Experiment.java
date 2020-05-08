package org.exp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "实验")
@Table(name = "exp_experiment")
public class Experiment {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "实验id", name = "expId", example = "1")
    @Id
    private Integer expId;
    /**
     * 实验名称
     */
    @ApiModelProperty(value = "实验名称", name = "expName", example = "网线制造", required = true)
    private String expName;

    /**
     * 实验课程id
     */
    @ApiModelProperty(value = "实验课程id", name = "expCourseId", example = "1", required = true)
    private Integer expCourseId;


    /**
     * 实验名称
     */
    @ApiModelProperty(value = "实验地址", name = "expLocation", example = "西区", required = true)
    private String expLocation;

    /**
     * 实验时间
     */
    @ApiModelProperty(value = "实验时间", name = "expTime", example = "2020-09-01 02:33", required = true)
    private String expTime;
    /**
     * 实验负责人
     */
    @ApiModelProperty(value = "实验负责人", name = "expTeacher", example = "张老三", required = true)
    private String expTeacher;

    /**
     * 实验文件地址
     */
    @ApiModelProperty(value = "实验文件地址", name = "expFileUrl", example = "")
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

    public Integer getExpCourseId() {
        return expCourseId;
    }

    public void setExpCourseId(Integer expCourseId) {
        this.expCourseId = expCourseId;
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
