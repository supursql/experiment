package org.exp.mapper;

import org.apache.ibatis.annotations.Param;
import org.exp.pojo.Course;
import org.exp.utils.MyMapper;
import org.exp.vo.ExperimentVO;

import java.util.List;

public interface ExperimentCustomMapper extends MyMapper<ExperimentVO> {
    List<Course> selectExperimentByUserId(@Param("list") List<Integer> list);

    List<Course> selectExperimentByKeyWord(List<Integer> list, String keyWord);

    ExperimentVO queryExperimentById(int expId);
}
