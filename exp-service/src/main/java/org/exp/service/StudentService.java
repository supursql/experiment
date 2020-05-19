package org.exp.service;

import org.exp.exception.BizException;
import org.exp.pojo.Student;
import org.exp.vo.StudentVO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface StudentService {

    StudentVO queryStudentIsExist(String stuNum, String stuPass) throws BizException, NoSuchAlgorithmException;

    boolean queryUserNumIsExist(String stuNum);

    boolean saveStudent(Student student);

    StudentVO queryUserInfoById(int stuId);

    boolean updateUserInfo(Student student);

    List<StudentVO> queryStudentsByCourseId(int courseId);

    boolean addCourse(String stuId, String courseId);
}
