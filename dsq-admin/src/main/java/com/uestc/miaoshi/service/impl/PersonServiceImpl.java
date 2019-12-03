package com.uestc.miaoshi.service.impl;

import com.uestc.miaoshi.dao.PersonRepository;
import com.uestc.miaoshi.model.Person;
import com.uestc.miaoshi.service.PersonOtherService;
import com.uestc.miaoshi.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    PersonRepository personRepository;
    @Autowired
    private PersonOtherService personOtherService ;
    @Override
    public void insert() {
        log.info("start insert @@@@@@@@@@@@@@@@@");
        Person p = new Person() ;
        p.setId(1);
        p.setName("one");

        personRepository.save(p) ;
        personOtherService.insert2();
        log.info("end insert @@@@@@@@@@@@@@@@@");
    }
}

