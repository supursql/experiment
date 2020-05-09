package org.exp.mapper;

import org.exp.pojo.Score;
import org.exp.utils.MyMapper;

public interface ScoreMapper extends MyMapper<Score> {
    void addTeacherInfo(String scoreId, Double score, String teacherInfo);

    void addStuFilePath(String filepath, String scoreId);

    void deleteByScoreId(int scoreId);
}
