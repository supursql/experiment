package org.exp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer scoreResponse;


}
