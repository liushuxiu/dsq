package com.uestc.miaoshi.dsqadmin;

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
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ApplicationTest.class, DataSourceAutoConfiguration.class})
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "select * from student";
        List<com.uestc.miaoshi.model.Student> query = jdbcTemplate.query(sql, new com.uestc.miaoshi.model.Student());
        Student stu = new Student("a", 0, "x");
        studentMapper.insert(stu);

        List<Student> studentList = studentMapper.selectAll();
        Assert.assertEquals(1, studentList.size());
    }
}
