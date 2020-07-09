package com.example.webapppratice01.controller;


import com.example.webapppratice01.mapper.UserMapper;
import com.example.webapppratice01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class hicontroller {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/register") //映射到localhost里的register路径下
    public String reg(){
        return "register";
    }
    @RequestMapping("/register")//
    public String register(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
      //  System.out.println(username);
      //  System.out.println(password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        User user1 = userMapper.getuser(username);
        if(user1!=null){
            map.put("msg1","the user has been used,pls register again");
            return"register";
                            }else{
            userMapper.adduser(user);
            return"login";
        }
    }

    @RequestMapping("/getuser")
    public String getuser(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if(user!=null){
            map.put("msg","the user has been register");
            return "register";
        }else{
            map.put("msg","the user has not been used");
            return "register";
        }
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        map.put("msg2","the user "+loginuser+"login");
        return "login";
    }
    @RequestMapping("/delectuser")
    public String delectuser(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        User getuser = userMapper.getuser(username);
        if(getuser!=null){
            userMapper.deleteuser(username);
            map.put("msg3","the user has been deleted!");
            return"login";
        }else{
            map.put("msg3","the user is not a legal user" );
            return"login";
        }
    }
    @RequestMapping("/updateuser")
    public String updata(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User getuser = userMapper.getuser(username);
        if(getuser!=null){
            userMapper.updateuser(username,password);
            map.put("msg4","the user has been updated!");
            return"login";
        }else{
            map.put("msg4","the user is not a legal user" );
            return"login";
        }
    }
}
