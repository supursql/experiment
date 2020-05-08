package org.exp.service;

import org.exp.pojo.Score;
import org.exp.vo.ScoreVO;

import java.util.List;

public interface ScoreService {
    List<ScoreVO> queryScoreByUserId(int parseInt);

    boolean addTeacherInfo(String scoreId, Double score, String teacherInfo);

    boolean addStuFile(String filepath, String scoreId);
}
