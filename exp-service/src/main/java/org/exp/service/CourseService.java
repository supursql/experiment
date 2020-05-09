package org.exp.service;

import org.exp.pojo.Course;
import org.exp.utils.PagedResult;

import java.util.List;

public interface CourseService {
    PagedResult queryCourseByUserId(int stuId, int page, int pageSize);

    boolean delete(int courseId);

    boolean add(Course course);

    boolean update(Course course);
}
