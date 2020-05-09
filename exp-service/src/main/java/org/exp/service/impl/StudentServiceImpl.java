package org.exp.service.impl;

import org.exp.mapper.StudentCustomMapper;
import org.exp.mapper.StudentMapper;
import org.exp.exception.BizException;
import org.exp.pojo.Student;
import org.exp.service.StudentService;
import org.exp.utils.MD5Utils;
import org.exp.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentCustomMapper studentCustomMapper;


    @Override
    public StudentVO queryStudentIsExist(String stuNum, String stuPass) throws BizException, NoSuchAlgorithmException {

        StudentVO user = new StudentVO();
        user.setStuNum(stuNum);

        StudentVO res = studentCustomMapper.selectOne(user);

        if (res == null) {
            throw new BizException("用户名不存在");
        } else if (!MD5Utils.getMD5Str(stuPass).equals(res.getStuPass())){
            throw new BizException("密码不正确");
        }

        return res;
    }

    @Override
    public boolean queryUserNumIsExist(String stuNum) {

        Student user = new Student();
        user.setStuNum(stuNum);

        Student res = studentMapper.selectOne(user);

        return res != null;
    }

    @Override
    public boolean saveStudent(Student student) {
        return studentMapper.insert(student) != 0;
    }

    @Override
    public StudentVO queryUserInfoById(int stuId) {
        return studentCustomMapper.queryUserInfoById(stuId);
    }

    @Override
    public boolean updateUserInfo(Student student) {
        Example userInfo = new Example(Student.class);
        Example.Criteria criteria = userInfo.createCriteria();
        criteria.andEqualTo("stuId", student.getStuId());

        return studentMapper.updateByExampleSelective(student, userInfo) != 0;
    }

    @Override
    public List<StudentVO> queryStudentsByCourseId(int courseId) {
        return studentCustomMapper.queryStudentsByCourseId(courseId);
    }
}
