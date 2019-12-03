package com.uestc.miaoshi.controller;


import com.uestc.miaoshi.dao.UserRepositry;
import com.uestc.miaoshi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 *
 * User控制层
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepositry userRepositoty;

    @RequestMapping(value = "/index")
    public String index(){

        List<User> all = userRepositoty.findAll();
        userRepositoty.findByUserName("ly");
        User save = userRepositoty.save(new User().setNickname("liuyan3").setEmail("sss").setPassword("ddd"));
        System.out.println(save);


        System.out.println(all.size());
        return "user/index";
    }


}
