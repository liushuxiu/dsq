package com.uestc.miaoshi.dao;

import com.uestc.miaoshi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    /**
     *
     * @param age
     * @return 通过年龄查找返回一个列表
     */
    public List<Person> findByAge(Integer age);

    public List<Person> findByAgeAndName(Integer age, String name);

}

