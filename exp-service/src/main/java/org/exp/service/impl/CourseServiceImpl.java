package org.exp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.exp.mapper.CourseMapper;
import org.exp.pojo.Course;
import org.exp.pojo.Experiment;
import org.exp.service.CourseService;
import org.exp.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
        Example recordInfo = new Example(Course.class);
        Example.Criteria criteria = recordInfo.createCriteria();
        criteria.andEqualTo("courseId", course.getCourseId());

        return courseMapper.updateByExampleSelective(course, recordInfo) != 0;
    }
}
