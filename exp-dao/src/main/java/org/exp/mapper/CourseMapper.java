package org.exp.mapper;

import org.apache.ibatis.annotations.Param;
import org.exp.pojo.Course;
import org.exp.utils.MyMapper;

import java.util.List;

public interface CourseMapper extends MyMapper<Course> {

    List<Course> selectCourseByUserId(int stuId);

    void deleteCourse(int courseId);

}
