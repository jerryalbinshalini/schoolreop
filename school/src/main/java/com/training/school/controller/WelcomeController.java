package com.training.school.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class WelcomeController {
    @RequestMapping(path="/SB",method = RequestMethod.GET)
    public String getGreetingForSpringBoot(){
        return "Welcome to SpringBoot";
    }
    @RequestMapping(path="/Java",method = RequestMethod.GET)
    public String getGreetingForJava(){
        return "Welcome to Java";
    }
}
