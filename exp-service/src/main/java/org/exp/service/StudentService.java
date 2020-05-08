package org.exp.service;

import org.exp.exception.BizException;
import org.exp.pojo.Student;
import org.exp.vo.StudentVO;

import java.security.NoSuchAlgorithmException;

public interface StudentService {

    StudentVO queryDepartmentById(int parseInt);

    boolean updateDepartment(Student student);

    StudentVO queryStudentIsExist(String stuNum, String stuPass) throws BizException, NoSuchAlgorithmException;

    boolean queryUserNumIsExist(String stuNum);

    boolean saveStudent(Student student);
}
