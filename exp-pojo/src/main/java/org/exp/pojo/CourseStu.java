package org.exp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "课程学生关联")
@Table(name = "exp_course_stu")
public class CourseStu {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "关联id", name = "courseStuId", example = "1")
    @Id
    private Integer courseStuId;

    /**
     * 课程名称
     */
    @ApiModelProperty(value = "课程id", name = "courseId", example = "1", required = true)
    private Integer courseId;

    /**
     * 学生名称
     */
    @ApiModelProperty(value = "学生id", name = "stuId", example = "2", required = true)
    private Integer stuId;

    public Integer getCourseStuId() {
        return courseStuId;
    }

    public void setCourseStuId(Integer courseStuId) {
        this.courseStuId = courseStuId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}
