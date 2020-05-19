package org.exp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "exp_score")
public class ScoreVO {

    /**
     * 自增id
     */
    private Integer scoreId;
    /**
     * 学生
     */
    private String stuName;

    /**
     * 实验
     */
    private String expName;

    /**
     * 分数
     */
    private Double scoreRes;


    /**
     * 实验结果
     */
    private String scoreResFile;


    /**
     * 实验评语
     */
    private String scoreResponse;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public Double getScoreRes() {
        return scoreRes;
    }

    public void setScoreRes(Double scoreRes) {
        this.scoreRes = scoreRes;
    }

    public String getScoreResFile() {
        return scoreResFile;
    }

    public void setScoreResFile(String scoreResFile) {
        this.scoreResFile = scoreResFile;
    }

    public String getScoreResponse() {
        return scoreResponse;
    }

    public void setScoreResponse(String scoreResponse) {
        this.scoreResponse = scoreResponse;
    }
}
