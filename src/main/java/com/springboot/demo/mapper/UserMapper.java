package com.springboot.demo.mapper;

import com.springboot.demo.PO.UserPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    UserPO getUserById(@Param("id") Long id) throws Exception;

    @Insert("insert into user values (null,#{user.name})")
    void insertUser(@Param("user")UserPO user) throws Exception;

    @Select("select * from user where name = #{name}")
    UserPO getUserByName(@Param("name") String name) throws Exception;
}
