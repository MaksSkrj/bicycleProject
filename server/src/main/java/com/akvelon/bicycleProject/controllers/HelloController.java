package com.akvelon.bicycleProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

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
