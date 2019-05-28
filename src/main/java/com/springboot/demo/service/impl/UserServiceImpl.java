package com.springboot.demo.service.impl;

import com.springboot.demo.PO.UserPO;
import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 开启事务
     * @return
     * @throws Exception
     */
    @Transactional
    @Override
    public boolean tranfor() throws Exception {
        return false;
    }

    @Override
    public UserPO getUserByName(String name) throws Exception {
        UserPO userPO = userMapper.getUserByName(name);
        return userPO;
    }
}
