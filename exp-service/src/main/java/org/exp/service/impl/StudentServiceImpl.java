package org.exp.service.impl;

import org.exp.exception.BizException;
import org.exp.pojo.Student;
import org.exp.service.StudentService;
import org.exp.vo.StudentVO;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentVO queryDepartmentById(int parseInt) {
        return null;
    }

    @Override
    public boolean updateDepartment(Student student) {
        return false;
    }

    @Override
    public StudentVO queryStudentIsExist(String stuNum, String stuPass) throws BizException, NoSuchAlgorithmException {
        return null;
    }

    @Override
    public boolean queryUserNumIsExist(String stuNum) {
        return false;
    }

    @Override
    public boolean saveStudent(Student student) {
        return false;
    }
}
