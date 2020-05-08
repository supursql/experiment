package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.exp.exception.BizException;
import org.exp.pojo.Student;
import org.exp.service.StudentService;
import org.exp.utils.MD5Utils;
import org.exp.utils.ResultUtils;
import org.exp.vo.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static org.exp.interceptor.MiniInterceptor.USER_REDIS_SESSION;


/**
 * @author: 紫苏
 * @date: 2020/5/5 上午12:11
 * @description:
 */
@RestController
@Api(value = "用户注册登录的接口", tags = {"注册和登录接口"})
public class RegisterLoginController extends BasicController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/stu/register")
    public ResultUtils regist(@RequestBody Student student) throws NoSuchAlgorithmException {

        if (StringUtils.isBlank(student.getStuClass()) || StringUtils.isBlank(student.getStuName())
                || StringUtils.isBlank(student.getStuNum()) || StringUtils.isBlank(student.getStuPass())) {
            return ResultUtils.errorMsg("必填项不为空");
        }

        if (!studentService.queryUserNumIsExist(student.getStuNum())) {
            student.setStuPass(MD5Utils.getMD5Str(student.getStuPass()));
            studentService.saveStudent(student);
        } else {
            return ResultUtils.errorMsg("用户名已存在");
        }

        student.setStuPass("");

        StudentVO studentVO = new StudentVO();

        BeanUtils.copyProperties(studentVO, student);

        return ResultUtils.ok(setUserRedisSessionToken(studentVO));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/stu/login")
    public ResultUtils login(String stuNum, String password) throws NoSuchAlgorithmException {

        Student user = new Student();
        user.setStuNum(stuNum);
        user.setStuPass(password);

        if (StringUtils.isBlank(user.getStuNum()) || StringUtils.isBlank(user.getStuPass())) {
            return ResultUtils.errorMsg("用户名和密码不能为空");
        }

        try {
            StudentVO res = studentService.queryStudentIsExist(user.getStuNum(), user.getStuPass());
            if (res != null) {
                res.setStuPass("");
                return ResultUtils.ok(setUserRedisSessionToken(res));
            }
        } catch (BizException e) {
            return ResultUtils.errorMsg(e.getMessage());
        }

        return ResultUtils.errorException("通信错误");

    }


    @ApiOperation(value = "管理员登录")
    @PostMapping("/admin/login")
    public ResultUtils docLogin(String username, String password) throws NoSuchAlgorithmException {

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResultUtils.errorMsg("用户名和密码不能为空");
        }

        return ResultUtils.errorException("暂未开通");

    }

    @ApiOperation(value = "用户注销")
    @ApiImplicitParam(name = "stuId", value = "用户Id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/stu/logout")
    public ResultUtils logout(String stuId) throws NoSuchAlgorithmException {

        redis.del(USER_REDIS_SESSION + ":" + stuId);

        return ResultUtils.ok("注销成功 ");

    }

    private StudentVO setUserRedisSessionToken(StudentVO studentVO) {

        String uniqueToken = UUID.randomUUID().toString();
        redis.set(USER_REDIS_SESSION + ":" + studentVO.getStuId(), uniqueToken, 1000*60*30);

        StudentVO vo = new StudentVO();
        BeanUtils.copyProperties(studentVO, vo);

        vo.setStuToken(uniqueToken);

        return vo;
    }

}
