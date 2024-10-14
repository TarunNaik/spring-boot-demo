package com.springpoc.springbootdemo.controller;

import com.springpoc.springbootdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abc")
public class HomeController {

    @GetMapping("/hello")
    public String home() {
        return "Hello World!!!";
    }

    @GetMapping("/user")
    public User getUser() {
        User user = new User();
        user.setId("111");
        user.setName("User1");
        user.setEmail("sss@hhh.com");
        return user;
    }

    @GetMapping("/reqParam")
    public String getDetails(@RequestParam String name, @RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
        return "Hello "+name+" and email "+emailId;
    }
}
