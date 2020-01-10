package com.uestc.miaoshi.dsqadmin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScoreMapper {
    @Insert("INSERT INTO score (name, score) VALUES (#{name}, #{score})")
    int insert(Score score);

    @Select("select * from score")
    List<Score> selectAll();
}
