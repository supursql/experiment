package org.exp.service;

import org.exp.pojo.Experiment;
import org.exp.utils.PagedResult;
import org.exp.vo.ExperimentVO;

import java.util.List;

public interface ExperimentService {

    PagedResult queryExperimentByUserId(int stuId, int page, int pageSize);

    ExperimentVO queryExperimentById(int expId);

    boolean addExperiment(Experiment experiment);

    boolean endExperiment(int expId);

    boolean updateExperiment(Experiment experiment);

    PagedResult queryExperimentByKeyWord(String keyWord, int page, int pageSize, int stuId);

    List<Integer> queryExperimentByCourseId(int courseId);

    boolean addScores(List<Integer> experimentIds, int userId);
}
