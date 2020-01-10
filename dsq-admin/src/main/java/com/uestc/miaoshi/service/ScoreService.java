package com.uestc.miaoshi.service;

import com.uestc.miaoshi.dao.mybatis.ScoreMapper;
import com.uestc.miaoshi.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ScoreService {

    Score get(String name);

}
