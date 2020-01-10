package com.uestc.miaoshi.dsqadmin;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Score implements Serializable, RowMapper<Score> {
    private int id;
    private String name;
    private int  score;


    public Score() {}

    public Score(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public Score mapRow(ResultSet rs, int i) throws SQLException {
        Score score = new Score();
        score.id = rs.getInt("id");
        score.name = rs.getString("name");
        score.score = rs.getInt("score");
        return score;
    }
}
