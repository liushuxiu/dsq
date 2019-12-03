package com.uestc.miaoshi.service.impl;

import com.uestc.miaoshi.dao.PersonRepository;
import com.uestc.miaoshi.model.Person;
import com.uestc.miaoshi.service.PersonOtherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class PersonOtherServiceImpl implements PersonOtherService {
    private static final Logger log = LoggerFactory.getLogger(PersonOtherServiceImpl.class);
    @Autowired
    private PersonRepository personMapper ;
    @Override
    public void insert2() {
        log.info("start update !!!!!!!!!!!!!!");
        Person person = new Person() ;
        person.setId(2);
        person.setName("two");
        personMapper.save(person) ;
        log.info("end update !!!!!!!!!!!!!!!");
        int i = 1/0 ;
    }
}