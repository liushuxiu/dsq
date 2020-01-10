package com.uestc.miaoshi.dsqadmin;

import com.uestc.miaoshi.DsqAdminApplication;
import com.uestc.miaoshi.dao.mybatis.ScoreMapper;
import com.uestc.miaoshi.model.Score;
import com.uestc.miaoshi.model.Student;
import com.uestc.miaoshi.service.ScoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

//@ActiveProfiles("application.properties")
@ActiveProfiles("ut")
//@ActiveProfiles("ly")
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class, DataSourceAutoConfiguration.class})
public class ScoreMapperTest {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @MockBean
    private ScoreService scoreService;

    @Test
    public void mockTest() {
        given(scoreService.get(anyString())).willReturn(new Score(1, "a", 24));
        Score b = scoreService.get("b");
        System.out.println(b.getScore());
    }

    @Test
    public void testInsert() {
        String sql = "select * from score";
        List<Score> query = jdbcTemplate.query(sql, new Score());
        Score stu = new Score(1, "name", 100);
        scoreMapper.insert(stu);

        List<Score> scoreList = scoreMapper.selectAll();
        Assert.assertEquals(2, scoreList.size());
    }
}
