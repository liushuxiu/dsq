package com.uestc.miaoshi.service;

import com.uestc.miaoshi.service.impl.PersonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {



    /**
     * Spring boot开启事务只需要添加@Transactional即可！
     *
     */
//    @Transactional
//    public void insertTwo() throws Exception {
//        Person person1 = new Person();
//        person1.setAge(18);
//        person1.setName("李斯");
//        personRepository.save(person1);
//
//        //将数据库字段设置为2个字节，超过就报错
//        Person person2 = new Person();
//        person2.setAge(28);
//        person2.setName("曹操666");
//        personRepository.save(person2);
//    }


    public void insert();

    public void testAop();



}
