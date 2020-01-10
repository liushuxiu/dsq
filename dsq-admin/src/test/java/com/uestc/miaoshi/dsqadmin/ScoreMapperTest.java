package com.uestc.miaoshi.dsqadmin;

import com.uestc.miaoshi.DsqAdminApplication;
import com.uestc.miaoshi.dao.mybatis.ScoreMapper;
import com.uestc.miaoshi.model.Score;
import com.uestc.miaoshi.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ActiveProfiles("application.properties")
//@ActiveProfiles("ut")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DsqAdminApplication.class, DataSourceAutoConfiguration.class})
public class ScoreMapperTest {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "select * from score";
        List<Score> query = jdbcTemplate.query(sql, new Score());
        Score stu = new Score(1, "name", 100);
        scoreMapper.insert(stu);

        List<Score> scoreList = scoreMapper.selectAll();
        Assert.assertEquals(1, scoreList.size());
    }
}
