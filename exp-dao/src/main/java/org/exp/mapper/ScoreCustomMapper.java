package org.exp.mapper;

import org.exp.utils.MyMapper;
import org.exp.vo.ScoreVO;

import java.util.List;

public interface ScoreCustomMapper extends MyMapper<ScoreVO> {
    List<ScoreVO> selectScoreByUserId(int stuId);
}
