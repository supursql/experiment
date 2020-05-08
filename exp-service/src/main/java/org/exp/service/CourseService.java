package org.exp.service;

import org.exp.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryCourseByUserId(int parseInt);

    boolean delete(int parseInt);

    boolean add(Course course);

    boolean update(Course course);
}
