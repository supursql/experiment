package org.exp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.exp.pojo.Experiment;
import org.exp.service.ExperimentService;
import org.exp.service.StudentService;
import org.exp.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("experiment")
@Api(value = "实验的接口", tags = {"实验的接口"})
public class ExperimentController extends BasicController {

    @Autowired
    private ExperimentService experimentService;

    @ApiOperation(value = "按照学生id来查询所选实验")
    @ApiImplicitParam(name = "stuId", value = "学生Id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/findWithUserId")
    public ResultUtils findWithUserId(String stuId) {
        return ResultUtils.ok(experimentService.queryExperimentByUserId(Integer.parseInt(stuId)));
    }

    @ApiOperation(value = "按照实验id来查询所选实验信息")
    @ApiImplicitParam(name = "expId", value = "实验Id", required = true,
            dataType = "String", paramType = "query")
    @GetMapping("/findWithId")
    public ResultUtils findWithId(String expId) {
        return ResultUtils.ok(experimentService.queryExperimentById(Integer.parseInt(expId)));
    }

    @ApiOperation(value = "增加实验")
    @PostMapping("/add")
    public ResultUtils add(@RequestBody Experiment experiment) {
        return ResultUtils.ok(experimentService.addExperiment(experiment));
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
