package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.exp.pojo.Student;
import org.exp.service.StudentService;
import org.exp.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Api(value = "学生相关接口", tags = {"学生相关接口"})
public class StudentController extends BasicController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "按照学生id来查询学生信息")
    @ApiImplicitParam(name = "stuId", value = "学生Id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/detail")
    public ResultUtils detail(String stuId) {
        return ResultUtils.ok(studentService.queryUserInfoById(Integer.parseInt(stuId)));
    }

    @ApiOperation(value = "修改学生信息")
    @PostMapping("/update")
    public ResultUtils update(@RequestBody Student student) {
        return ResultUtils.ok(studentService.updateUserInfo(student));
    }

    @ApiOperation(value = "选课")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生Id", required = true,
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "courseId", value = "课程Id", required = true,
                    dataType = "String", paramType = "query")
    })
    @PostMapping("/addCourse")
    public ResultUtils addCourse(String stuId, String courseId) {
        return ResultUtils.ok(studentService.addCourse(stuId, courseId));
    }


}
