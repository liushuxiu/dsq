package com.uestc.miaoshi.controller;

import com.google.gson.Gson;
import com.uestc.miaoshi.dao.PersonRepository;
import com.uestc.miaoshi.model.Person;
import com.uestc.miaoshi.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;

import static org.springframework.data.domain.Sort.*;

/**
 * Created by HP on 2018/7/30.
 */
@RestController
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    static final Gson gson = new Gson();


    @GetMapping("/fenye")
    public void findPerson(int page, int size) throws Exception {
        Sort sort;
        sort =  Sort.by(Direction.DESC, "age");
        Page<Person> all;
        all = personRepository.findAll( PageRequest.of(page, size,sort));
        System.out.println(all);
    }


    @GetMapping("/nameAndAge")
    public void findPerson(String name, int age) throws Exception {
        List<Person> byAgeAndName = personRepository.findByAgeAndName(age, name);
        System.out.println(byAgeAndName);
    }


    /**
     * 1.查询列表
     */
    @GetMapping(value = "/find/personList")
    public List<Person> findAllPerson() {
        logger.info("查询列表");
        return personRepository.findAll();
    }

    /**
     * 2.添加一位员工信息
     */
    @PostMapping(value="/add/onePerson")
    public Person addPerson(@RequestParam("name") String name, @RequestParam("age") Integer age){
        logger.info("添加一位员工信息");
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }
    /**
     * 3.查询一个人
     * @return
     */
    @GetMapping(value = "/person/{id}")
    public String  findPerson(@PathVariable("id") Integer id){
        logger.info("查询一个人");
        //使用此方法
        Person person = personRepository.findById(id).orElse(null);
        return gson.toJson(person);
    }
    @GetMapping(value = "/person/age/{age}")
    public List<Person> findListPerson(@PathVariable("age") Integer age){
        logger.info("通过年龄查询");
        return personRepository.findByAge(age);
    }
    /**
     * 4.删除一条记录
     */
    @DeleteMapping(value = "/delete/person/{id}")
    public void delPerson(@PathVariable("id") Integer id){
        logger.info("删除一条记录");
        personRepository.deleteById(id);
    }
    /**
     * 5.更新数据
     */
    @PostMapping(value = "/update/person/{id}")
    public Person updatePerson(@PathVariable("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("age") Integer age){

        logger.info("更新个人数据");
        Person person=new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);

    }

}
