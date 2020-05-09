package org.exp.service.impl;

import org.exp.pojo.Experiment;
import org.exp.service.ExperimentService;
import org.exp.vo.ExperimentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Override
    public List<ExperimentVO> queryExperimentByUserId(int parseInt) {
        return null;
    }

    @Override
    public ExperimentVO queryExperimentById(int parseInt) {
        return null;
    }

    @Override
    public boolean addExperiment(Experiment experiment) {
        return false;
    }

    @Override
    public boolean endExperiment(int parseInt) {
        return false;
    }

    @Override
    public boolean updateExperiment(Experiment experiment) {
        return false;
    }

    @Override
    public List<ExperimentVO> queryExperimentByKeyWord(String keyWord) {
        return null;
    }
}
