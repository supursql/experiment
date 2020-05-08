package org.exp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "课程")
@Table(name = "exp_course")
public class Course {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "课程id", name = "courseId", example = "1")
    @Id
    private Integer courseId;

    /**
     * 课程名称
     */
    @ApiModelProperty(value = "课程名称", name = "courseName", example = "计算机网络", required = true)
    private String courseName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
