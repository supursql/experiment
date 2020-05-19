package org.exp.mapper;

import org.exp.pojo.CourseStu;
import org.exp.utils.MyMapper;

/**
 * @author: 紫苏
 * @date: 2020/5/17 下午12:50
 * @description:
 */
public interface CourseStuMapper extends MyMapper<CourseStu> {

    int addCourse(Integer stuId, Integer courseId);

}
