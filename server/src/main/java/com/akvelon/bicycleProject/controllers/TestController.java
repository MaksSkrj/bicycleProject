package com.akvelon.bicycleProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.akvelon.bicycleProject.DAO.impl.BikeDAOImpl;

/**
 * Created by maksym.skrypnyk
 */

@RestController
public class TestController {
    @Autowired
    private BikeDAOImpl bikeDAO;

    @RequestMapping("/test")
    @ResponseBody
    public String testSelectAll() {
        StringBuilder result = new StringBuilder();
        bikeDAO.insert("test", "red", 11.1, 1, 1, 100., 10);
        result.append("getAll: " + bikeDAO.getAll().toString()).append(System.lineSeparator());
        //.append("getByID: " + bikeDAO.getById(3)).append(System.lineSeparator());
        //.append("getBy: " + bikeDAO.getBy("weight","10.3"));
        return result.toString();

    }

}
