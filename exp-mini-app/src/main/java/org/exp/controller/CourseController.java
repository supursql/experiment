package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.exp.pojo.Course;
import org.exp.service.CourseService;
import org.exp.service.ExperimentService;
import org.exp.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
@Api(value = "课程的接口", tags = {"课程的接口"})
public class CourseController extends BasicController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "按照学生id来查询所选课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生Id(-1:查询所有的学生)", required = true,
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true,
                    dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true,
                    dataType = "int", paramType = "query")
    })
    @GetMapping("/findWithUserId")
    public ResultUtils findWithUserId(String stuId, Integer page, Integer pageSize) {

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        return ResultUtils.ok(courseService.queryCourseByUserId(Integer.parseInt(stuId), page, pageSize));
    }


    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "courseId", value = "课程id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/delete")
    public ResultUtils delete(String courseId) {
        return ResultUtils.ok(courseService.delete(Integer.parseInt(courseId)));
    }

    @ApiOperation(value = "增加")
    @PostMapping("/add")
    public ResultUtils add(@RequestBody Course course) {
        return ResultUtils.ok(courseService.add(course));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public ResultUtils update(@RequestBody Course course) {
        return ResultUtils.ok(courseService.update(course));
    }

}
