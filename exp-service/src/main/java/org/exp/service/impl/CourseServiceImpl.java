package org.exp.service.impl;

import org.exp.pojo.Course;
import org.exp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> queryCourseByUserId(int parseInt) {
        return null;
    }

    @Override
    public boolean delete(int parseInt) {
        return false;
    }

    @Override
    public boolean add(Course course) {
        return false;
    }

    @Override
    public boolean update(Course course) {
        return false;
    }
}
