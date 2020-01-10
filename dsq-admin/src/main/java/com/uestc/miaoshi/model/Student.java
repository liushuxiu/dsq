package com.uestc.miaoshi.model;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name="student")
@Data
public class Student implements RowMapper<Student> {

    @Id
    @GeneratedValue
    private  Integer id;
    private String name;
    private String addr;
    private Integer age;

    @Override
    public com.uestc.miaoshi.model.Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student();
        student.id = rs.getInt("id");
        student.name = rs.getString("name");
        student.age = rs.getInt("age");
        student.addr = rs.getString("addr");
        return student;
    }
}


