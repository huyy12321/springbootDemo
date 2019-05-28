package com.springboot.demo.service;

import com.springboot.demo.PO.UserPO;

public interface UserService {

     boolean tranfor() throws Exception;

     UserPO getUserByName(String name) throws Exception;
}
