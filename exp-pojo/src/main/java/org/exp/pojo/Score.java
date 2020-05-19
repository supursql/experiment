package org.exp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "实验")
@Table(name = "exp_score")
public class Score {

    @ApiModelProperty(value = "结果id", name = "scoreId", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scoreId;

    /**
     * 学生id
     */
    @ApiModelProperty(value = "学生id", name = "scoreStu", example = "1", required = true)
    private Integer scoreStu;

    /**
     * 实验id
     */
    @ApiModelProperty(value = "实验id", name = "scoreExp", example = "1", required = true)
    private Integer scoreExp;

    /**
     * 分数
     */
    @ApiModelProperty(value = "分数", name = "scoreRes", example = "81.00")
    private Double scoreRes;


    /**
     * 实验结果
     */
    @ApiModelProperty(value = "实验结果文件", name = "scoreResFile", example = "12")
    private String scoreResFile;


    /**
     * 实验评语
     */
    @ApiModelProperty(value = "实验评语", name = "scoreResponse", example = "啦啦啦啦")
    private Integer scoreResponse;

    public Integer getScoreStu() {
        return scoreStu;
    }

    public void setScoreStu(Integer scoreStu) {
        this.scoreStu = scoreStu;
    }

    public Integer getScoreExp() {
        return scoreExp;
    }

    public void setScoreExp(Integer scoreExp) {
        this.scoreExp = scoreExp;
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

    public Integer getScoreResponse() {
        return scoreResponse;
    }

    public void setScoreResponse(Integer scoreResponse) {
        this.scoreResponse = scoreResponse;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreStu=" + scoreStu +
                ", scoreExp=" + scoreExp +
                ", scoreRes=" + scoreRes +
                ", scoreResFile='" + scoreResFile + '\'' +
                ", scoreResponse=" + scoreResponse +
                '}';
    }
}
