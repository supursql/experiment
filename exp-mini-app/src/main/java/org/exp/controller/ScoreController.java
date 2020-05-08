package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.exp.service.CourseService;
import org.exp.service.ScoreService;
import org.exp.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("score")
@Api(value = "分数的接口", tags = {"分数的接口"})
public class ScoreController extends BasicController {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "按照学生id来查询实验结果")
    @ApiImplicitParam(name = "stuId", value = "学生Id(-1:查询所有的学生)", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/findWithUserId")
    public ResultUtils findWithUserId(String stuId) {
        return ResultUtils.ok(scoreService.queryScoreByUserId(Integer.parseInt(stuId)));
    }

    @ApiOperation(value = "教师添加评语")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "scoreId", value = "实验结果id", required = true,
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "score", value = "分数", required = true,
                    dataType = "Double", paramType = "query"),
            @ApiImplicitParam(name = "teacherInfo", value = "教师评语", required = false,
                    dataType = "String", paramType = "query")
    })
    @PostMapping("/addTeacherInfo")
    public ResultUtils addTeacherInfo(String scoreId, Double score, String teacherInfo) {
        return ResultUtils.ok(scoreService.addTeacherInfo(scoreId, score, teacherInfo));
    }

    @ApiOperation(value = "学生上传实验结果文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true,
                    dataType = "MultipartFile", paramType = "query"),
            @ApiImplicitParam(name = "scoreId", value = "实验结果id", required = true,
                    dataType = "String", paramType = "query")
    })
    @PostMapping("/addStuFile")
    public ResultUtils addStuFile(MultipartFile file, String scoreId) {

        String filepath = "";

        return ResultUtils.ok(scoreService.addStuFile(filepath, scoreId));
    }

}
