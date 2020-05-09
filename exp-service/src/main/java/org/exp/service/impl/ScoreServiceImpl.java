package org.exp.service.impl;

import org.exp.service.ScoreService;
import org.exp.vo.ScoreVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Override
    public List<ScoreVO> queryScoreByUserId(int parseInt) {
        return null;
    }

    @Override
    public boolean addTeacherInfo(String scoreId, Double score, String teacherInfo) {
        return false;
    }

    @Override
    public boolean addStuFile(String filepath, String scoreId) {
        return false;
    }

    @Override
    public boolean delete(int parseInt) {
        return false;
    }
}
