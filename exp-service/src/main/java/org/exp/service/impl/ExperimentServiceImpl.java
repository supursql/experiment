package org.exp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.exp.mapper.CourseMapper;
import org.exp.mapper.ExperimentCustomMapper;
import org.exp.mapper.ExperimentMapper;
import org.exp.pojo.Course;
import org.exp.pojo.Experiment;
import org.exp.pojo.Score;
import org.exp.service.ExperimentService;
import org.exp.service.ScoreService;
import org.exp.service.StudentService;
import org.exp.utils.PagedResult;
import org.exp.vo.ExperimentVO;
import org.exp.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    private ExperimentMapper experimentMapper;

    @Autowired
    private ExperimentCustomMapper experimentCustomMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ScoreService scoreService;

    @Override
    public PagedResult queryExperimentByUserId(int stuId, int page, int pageSize) {

        PageHelper.startPage(page, pageSize);

        List<Integer> courseIds = courseMapper.selectCourseByUserId(stuId).stream().map(
                course -> {
                    return course.getCourseId();
                }
        ).collect(Collectors.toList());

        List<Course> list = experimentCustomMapper.selectExperimentByUserId(courseIds);

        PageInfo<Course> pageList = new PageInfo<>(list);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(list);
        pagedResult.setRecords(pageList.getTotal());

        return pagedResult;
    }

    @Override
    public List<Integer> queryExperimentByCourseId(int courseId) {

        List<Integer> experimentIds = experimentMapper.selectCourseByCourseId(courseId).stream().map(
                experiment -> {
                    return experiment.getExpId();
                }
        ).collect(Collectors.toList());


        return experimentIds;
    }

    @Override
    public ExperimentVO queryExperimentById(int expId) {

        return experimentCustomMapper.queryExperimentById(expId);

    }

    @Override
    @Transactional
    public boolean addExperiment(Experiment experiment) {
        int key = experimentMapper.insertExperiment(experiment);

        List<StudentVO> studentVOS = studentService.queryStudentsByCourseId(experiment.getExpCourseId());


        for (StudentVO stu:
             studentVOS) {
            Score score = new Score();
            score.setScoreExp(experiment.getExpId());
            score.setScoreStu(stu.getStuId());
            score.setScoreRes(0.0);

            scoreService.addScore(score);
        }

        return true;
    }

    @Override
    @Transactional
    public boolean addScores(List<Integer> experimentIds, int userId) {

        for (Integer experimentId:
                experimentIds) {
            Score score = new Score();
            score.setScoreExp(experimentId);
            score.setScoreStu(userId);
            score.setScoreRes(0.0);

            scoreService.addScore(score);
        }

        return true;
    }

    @Override
    public boolean endExperiment(int expId) {
        experimentMapper.endExperiment(expId);
        return true;
    }

    @Override
    public boolean updateExperiment(Experiment experiment) {
        Example recordInfo = new Example(Experiment.class);
        Example.Criteria criteria = recordInfo.createCriteria();
        criteria.andEqualTo("expId", experiment.getExpId());


        return experimentMapper.updateByExampleSelective(experiment, recordInfo) != 0;
    }

    @Override
    public PagedResult queryExperimentByKeyWord(String keyWord, int page, int pageSize, int stuId) {
        PageHelper.startPage(page, pageSize);

        List<Integer> courseIds = courseMapper.selectCourseByUserId(stuId).stream().map(
                course -> {
                    return course.getCourseId();
                }
        ).collect(Collectors.toList());

        System.out.println(keyWord);

        List<Course> list = experimentCustomMapper.selectExperimentByKeyWord(courseIds, keyWord);

        PageInfo<Course> pageList = new PageInfo<>(list);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(list);
        pagedResult.setRecords(pageList.getTotal());

        return pagedResult;
    }
}
