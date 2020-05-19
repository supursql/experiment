package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.exp.service.CourseService;
import org.exp.service.ScoreService;
import org.exp.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("score")
@Api(value = "实验结果的接口", tags = {"实验结果的接口"})
public class ScoreController extends BasicController {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "按照学生id来查询实验结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生Id(-1:查询所有的学生)", required = true,
                    dataType = "String", paramType = "query")
    })
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
    @PostMapping("/addStuFile")
    public ResultUtils addStuFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("scoreId") String scoreId
    ) throws FileNotFoundException {

        if (file.isEmpty()) {
            return ResultUtils.ok(false);
        }

        String oldName = file.getOriginalFilename();

        int index = oldName.lastIndexOf(".");

        String newName = new StringBuilder(String.valueOf(UUID.randomUUID())).append(oldName.hashCode()).append(".").append(oldName.substring(index + 1)).toString();


        File path = new File(ResourceUtils.getURL("classpath:").getPath());

        File upload = new File(path.getAbsolutePath(),"static/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        String filePath = "/var/www/html/";
        File dest = new File(filePath + newName);
        try {
            file.transferTo(dest);
            scoreService.addStuFile(filePath, scoreId);
            return ResultUtils.ok(true);
        } catch (IOException e) {
        }

        return ResultUtils.errorMsg("保存失败");
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "scoreId", value = "实验结果id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/delete")
    public ResultUtils delete(String scoreId) {
        return ResultUtils.ok(scoreService.delete(Integer.parseInt(scoreId)));
    }

}
