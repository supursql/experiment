package org.exp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "学生")
@Table(name = "exp_student")
public class Student {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "学生id", name = "stuId", example = "1")
    @Id
    private Integer stuId;

    /**
     * 学生名称
     */
    @ApiModelProperty(value = "学生学号", name = "stuNum", example = "04163000", required = true)
    private String stuNum;

    /**
     * 学生名称
     */
    @ApiModelProperty(value = "学生名称", name = "stuName", example = "张三", required = true)
    private String stuName;

    /**
     * 学生密码
     */
    @ApiModelProperty(value = "学生密码", name = "stuPass", example = "123456", required = true)
    private String stuPass;

    /**
     * 学生名称
     */
    @ApiModelProperty(value = "学生班级", name = "stuClass", example = "软件1602", required = true)
    private String stuClass;

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
