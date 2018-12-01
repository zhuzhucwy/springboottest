package com.zhg.config.controller;

import com.zhg.config.bean.User;
import com.zhg.config.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({User.class, UserInfo.class})
public class HelloController {

    @Value("${my.name}")
    private String name;

    @Autowired
    User user;

    @Autowired
    UserInfo userInfo;

    @RequestMapping(path = "username", method = RequestMethod.GET)
    public String getUserName(){
        return "hello, my name is " + name;
    }

    @RequestMapping(path = "getUser", method = RequestMethod.GET)
    public String getUser(){
        return "hello, user is: " + user.getName() + "-----" + user.getAge();
    }


    @RequestMapping(path = "getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(){
        return "hello, userInfo is " + userInfo.getUserid() + "----" + userInfo.getName() + "----" + userInfo.getAge();
    }


}
