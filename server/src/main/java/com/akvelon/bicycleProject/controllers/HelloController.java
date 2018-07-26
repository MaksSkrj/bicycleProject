package com.akvelon.bicycleProject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by maksym.skrypnyk
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello!";
    }

}
