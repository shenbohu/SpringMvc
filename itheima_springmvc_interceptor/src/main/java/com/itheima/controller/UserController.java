package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user, HttpSession session){

        return "forward:/login.jsp";
    }


    @RequestMapping("/pageQuery")
    public String pageQuery(@RequestParam(defaultValue = "1", required = false) int currentPage, @RequestParam(defaultValue = "5", required = false) int pageSize){
        System.out.println("UserController...pageQuery...");
        return "list";
    }


    @RequestMapping("/page")
    public void pagey(@RequestParam(defaultValue = "1", required = false) int currentPage, @RequestParam(defaultValue = "5", required = false) int pageSize){
      int i = 1/0;

    }



}
