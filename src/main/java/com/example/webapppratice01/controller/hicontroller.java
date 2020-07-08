package com.example.webapppratice01.controller;


import com.example.webapppratice01.mapper.UserMapper;
import com.example.webapppratice01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class hicontroller {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/register") //映射到localhost里的register路径下
    public String reg(){
        return "register";
    }
    @RequestMapping("/register")//
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
      //  System.out.println(username);
      //  System.out.println(password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.adduser(user);
        return "register";//响应为register页面
    }
}
