package controller;

import org.springframework.stereotype.Controller;



public class UserController {

    // 请求地址  http://localhost:8080/user/quick

    public String save(){
        System.out.println("Controller save running....");
        return "success";
    }

}
