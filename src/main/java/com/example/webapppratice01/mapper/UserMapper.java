package com.example.webapppratice01.mapper;

import com.example.webapppratice01.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(User user);
    @Select("select * from user where username=#{username}")
    User getuser(String username);
}

