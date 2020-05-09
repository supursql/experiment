package org.exp.mapper;

import org.exp.pojo.Experiment;
import org.exp.utils.MyMapper;

public interface ExperimentMapper extends MyMapper<Experiment> {
    void endExperiment(int expId);
}
