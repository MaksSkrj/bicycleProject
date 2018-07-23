package com.akvelon.bicycleProject.controllers;

import com.akvelon.bicycleProject.DAO.impl.BikeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */

@RestController
public class JSONTest {
    @Autowired
    private BikeDAOImpl bikeDAO;

    @RequestMapping("/json")
    @ResponseBody
    public List getTreckInJSON(){
        List list = (bikeDAO.getAll());
        return list;
    }
}
