package org.exp.service.impl;

import org.exp.mapper.ScoreCustomMapper;
import org.exp.mapper.ScoreMapper;
import org.exp.pojo.Score;
import org.exp.service.ScoreService;
import org.exp.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private ScoreCustomMapper scoreCustomMapper;

    @Override
    public List<ScoreVO> queryScoreByUserId(int stuId) {
        return scoreCustomMapper.selectScoreByUserId(stuId);
    }

    @Override
    public boolean addTeacherInfo(String scoreId, Double score, String teacherInfo) {
        scoreMapper.addTeacherInfo(scoreId, score, teacherInfo);
        scoreMapper.endScore(scoreId);
        return true;
    }

    @Override
    public boolean addStuFile(String filepath, String scoreId) {
        scoreMapper.addStuFilePath(filepath, scoreId);
        return true;
    }

    @Override
    public boolean delete(int scoreId) {
        scoreMapper.deleteByScoreId(scoreId);
        return true;
    }

    @Override
    public boolean addScore(Score score) {

        return scoreMapper.insert(score) != 0;
    }
}
