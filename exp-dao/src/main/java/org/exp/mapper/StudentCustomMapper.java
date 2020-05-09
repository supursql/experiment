package org.exp.mapper;

import org.exp.utils.MyMapper;
import org.exp.vo.StudentVO;

import java.util.List;

public interface StudentCustomMapper extends MyMapper<StudentVO> {
    List<StudentVO> queryStudentsByCourseId(int courseId);

    StudentVO queryUserInfoById(int stuId);
}
