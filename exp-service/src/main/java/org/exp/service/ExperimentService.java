package org.exp.service;

import org.exp.pojo.Experiment;
import org.exp.vo.ExperimentVO;

import java.util.List;

public interface ExperimentService {

    List<ExperimentVO> queryExperimentByUserId(int parseInt);

    ExperimentVO queryExperimentById(int parseInt);

    boolean addExperiment(Experiment experiment);

    boolean endExperiment(int parseInt);

    boolean updateExperiment(Experiment experiment);

    List<ExperimentVO> queryExperimentByKeyWord(String keyWord);
}
