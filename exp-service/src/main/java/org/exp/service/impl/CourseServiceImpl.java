package org.exp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.exp.mapper.CourseMapper;
import org.exp.pojo.Course;
import org.exp.service.CourseService;
import org.exp.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PagedResult queryCourseByUserId(int stuId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Course> list = courseMapper.selectCourseByUserId(stuId);

        PageInfo<Course> pageList = new PageInfo<>(list);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(list);
        pagedResult.setRecords(pageList.getTotal());

        return pagedResult;
    }

    @Override
    public boolean delete(int courseId) {

        courseMapper.deleteCourse(courseId);

        return true;
    }

    @Override
    public boolean add(Course course) {

        courseMapper.insert(course);

        return true;
    }

    @Override
    public boolean update(Course course) {
        courseMapper.updateCourse(course);

        return true;
    }
}
