package org.exp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;

@Table(name = "exp_student")
public class StudentVO {

    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 学生名称
     */
    private String stuNum;

    /**
     * 学生名称
     */
    private String stuName;

    /**
     * 学生密码
     */
    private String stuPass;

    /**
     * 学生名称
     */
    private String stuClass;

    private String stuToken;

    public String getStuToken() {
        return stuToken;
    }

    public void setStuToken(String stuToken) {
        this.stuToken = stuToken;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPass() {
        return stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }
}
