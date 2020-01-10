package com.uestc.miaoshi.service.impl;


import com.uestc.miaoshi.dao.mybatis.ScoreMapper;
import com.uestc.miaoshi.model.Score;
import com.uestc.miaoshi.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Score get(String name) {
        return scoreMapper.get(name);
    }
}


