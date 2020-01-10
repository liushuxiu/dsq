package com.uestc.miaoshi.dao;

import com.uestc.miaoshi.model.Person;
import com.uestc.miaoshi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {

    /**
     *
     * @param age
     * @return 通过年龄查找返回一个列表
     */
    public List<Student> findByAge(Integer age);

    public List<Student> findByAgeAndName(Integer age, String name);
}




