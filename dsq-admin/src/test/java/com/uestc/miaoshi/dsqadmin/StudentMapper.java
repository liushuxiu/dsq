package com.uestc.miaoshi.dsqadmin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO student (name, sex, addr) VALUES (#{name}, #{sex}, #{addr})")
    int insert(Student stu);

    @Select("select * from student")
    List<Student> selectAll();
}
