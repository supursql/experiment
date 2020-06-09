package org.exp.service.impl;

import org.exp.mapper.CourseStuMapper;
import org.exp.mapper.StudentCustomMapper;
import org.exp.mapper.StudentMapper;
import org.exp.exception.BizException;
import org.exp.pojo.Student;
import org.exp.service.ExperimentService;
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

    @Autowired
    private CourseStuMapper courseStuMapper;

    @Autowired
    private ExperimentService experimentService;


    @Override
    public StudentVO queryStudentIsExist(String stuNum, String stuPass) throws BizException, NoSuchAlgorithmException {

        StudentVO res = studentCustomMapper.queryStudentIsExist(stuNum);

        if (res == null) {
            throw new BizException("用户名不存在");
        } else if (!MD5Utils.getMD5Str(stuPass).equals(res.getStuPass())){
            System.out.println(stuPass);
            System.out.println(res.getStuPass());
            System.out.println(MD5Utils.getMD5Str(stuPass));
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
        try {
            student.setStuPass(MD5Utils.getMD5Str(student.getStuPass()));
        } catch (Exception e) {

        }
        Example.Criteria criteria = userInfo.createCriteria();
        criteria.andEqualTo("stuId", student.getStuId());

        return studentMapper.updateByExampleSelective(student, userInfo) != 0;
    }

    @Override
    public List<StudentVO> queryStudentsByCourseId(int courseId) {
        return studentCustomMapper.queryStudentsByCourseId(courseId);
    }

    @Override
    public boolean addCourse(String stuId, String courseId) {
        boolean condition1 = courseStuMapper.addCourse(Integer.valueOf(stuId), Integer.valueOf(courseId)) != 0;
        List<Integer> experimentIds = experimentService.queryExperimentByCourseId(Integer.valueOf(courseId));
        boolean condition2 = experimentService.addScores(experimentIds, Integer.valueOf(stuId));

        return condition1 && condition2;
    }
}
