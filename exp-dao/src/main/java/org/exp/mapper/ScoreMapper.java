package org.exp.mapper;

import org.apache.ibatis.annotations.Param;
import org.exp.pojo.Score;
import org.exp.utils.MyMapper;

public interface ScoreMapper extends MyMapper<Score> {
    void addTeacherInfo(String scoreId, Double score, String teacherInfo);

    void addStuFilePath(@Param("filepath") String filepath, @Param("stuId") String stuId, @Param("expId") String expId);

    void deleteByScoreId(int scoreId);

    void endScore(String scoreId);
}
