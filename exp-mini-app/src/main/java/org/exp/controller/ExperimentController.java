package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.exp.pojo.Experiment;
import org.exp.service.ExperimentService;
import org.exp.service.StudentService;
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
@RequestMapping("experiment")
@Api(value = "实验的接口", tags = {"实验的接口"})
public class ExperimentController extends BasicController {

    @Autowired
    private ExperimentService experimentService;

    @ApiOperation(value = "按照学生id来查询所选实验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生Id", required = true,
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

        return ResultUtils.ok(experimentService.queryExperimentByUserId(Integer.parseInt(stuId), page, pageSize));
    }

    @ApiOperation(value = "按照实验id来查询所选实验信息")
    @ApiImplicitParam(name = "expId", value = "实验Id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/findWithId")
    public ResultUtils findWithId(String expId) {
        return ResultUtils.ok(experimentService.queryExperimentById(Integer.parseInt(expId)));
    }

    @ApiOperation(value = "按照关键字来查询实验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyWord", value = "关键字",
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true,
                    dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true,
                    dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "stuId", value = "学生Id", required = true,
                    dataType = "String", paramType = "query"),
    })
    @GetMapping("/findWithKeyWord")
    public ResultUtils findWithKeyWord(String keyWord, int page, int pageSize, String stuId) {
        return ResultUtils.ok(experimentService.queryExperimentByKeyWord(keyWord, page, pageSize, Integer.parseInt(stuId)));
    }

    @ApiOperation(value = "增加实验")
    @PostMapping("/add")
    public ResultUtils add(
            @RequestParam("file") MultipartFile file,
            @RequestParam("expCourseId") String expCourseId,
            @RequestParam("expLocation") String expLocation,
            @RequestParam("expName") String expName,
            @RequestParam("expTeacher") String expTeacher,
            @RequestParam("expTime") String expTime
            ) throws FileNotFoundException {

        System.out.println(file.isEmpty());

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
//            service.save(newName, author, fileName, type, belongLabId);
            Experiment experiment = new Experiment();
            experiment.setExpFileUrl(newName);
            experiment.setExpCourseId(Integer.parseInt(expCourseId));
            experiment.setExpLocation(expLocation);
            experiment.setExpName(expName);
            experiment.setExpTeacher(expTeacher);
            experiment.setExpTime(expTime);

            experimentService.addExperiment(experiment);
            return ResultUtils.ok(true);
        } catch (IOException e) {
        }

        return ResultUtils.errorMsg("保存失败");

    }

    @ApiOperation(value = "结束实验")
    @ApiImplicitParam(name = "expId", value = "实验Id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/end")
    public ResultUtils end(String expId) {
        return ResultUtils.ok(experimentService.endExperiment(Integer.parseInt(expId)));
    }

    @ApiOperation(value = "编辑实验")
    @PostMapping("/update")
    public ResultUtils update(@RequestBody Experiment experiment) {
        return ResultUtils.ok(experimentService.updateExperiment(experiment));
    }

}
