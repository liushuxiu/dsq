package com.uestc.miaoshi.dsqadmin;

import com.uestc.miaoshi.DsqAdminApplication;
import com.uestc.miaoshi.dao.PersonRepository;
import com.uestc.miaoshi.dao.StudentRepository;
import com.uestc.miaoshi.model.Person;
import com.uestc.miaoshi.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DsqAdminApplication.class)
@ActiveProfiles("application-ut")

@ComponentScan("com.uestc.miaoshi")
public class DsqAdminApplicationTests {


    @Autowired
    private PersonRepository personMapper ;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    public void add() {
//        jdbcTemplate.execute("select * from kyc_result");

        Student s = new Student();
//        s.setAge(11);
        s.setName("aa");
        studentRepository.save(s);
        String sql = "select * from student";
        List<Student> query = jdbcTemplate.query(sql, new Student());
        studentRepository.findByAge(11);


        Person person = new Person();
        person.setAge(11);
        person.setName("aa");
        personMapper.save(person);

        List<Person> byAge = personMapper.findByAge(11);
        System.out.println(3);

    }

    @Test
    public  void get () {
        List<Person> byAge = personMapper.findByAge(1);
    }





}
