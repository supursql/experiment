package org.exp.mapper;

import org.apache.ibatis.annotations.Param;
import org.exp.pojo.Experiment;
import org.exp.utils.MyMapper;

import java.util.Collection;
import java.util.List;

public interface ExperimentMapper extends MyMapper<Experiment> {
    void endExperiment(int expId);

    int insertExperiment(@Param("experiment") Experiment experiment);

    List<Experiment> selectCourseByCourseId(@Param("courseId") int courseId);
}
