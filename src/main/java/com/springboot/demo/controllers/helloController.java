package com.springboot.demo.controllers;

import com.springboot.demo.PO.UserPO;
import com.springboot.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * RestController 自动集成了ResponseBody 返回的是json格式数据
 */
@RestController
public class helloController {

    @Resource
    private UserMapper userMapper;
    @RequestMapping("hello")
    public String hello(){
        return "index";
    }

    @RequestMapping("exception")
    public Integer exception(){
        int i = 2/0;
        return i;
    }


    @RequestMapping("getUserById")
    public UserPO getUserById(@RequestParam("id")Long id) throws Exception{
       UserPO userPO = userMapper.getUserById(id);
       return userPO;
    }

    @PostMapping("insertUser")
    public String insertUser(UserPO user) throws Exception{
       /* userMapper.insertUser(UserPO.builder().name(name).build());*/
        userMapper.insertUser(user);
        return "success";
    }
 }
