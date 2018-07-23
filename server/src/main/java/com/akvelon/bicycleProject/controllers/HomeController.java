package com.akvelon.bicycleProject.controllers;

import com.akvelon.bicycleProject.DAO.impl.BikeDAOImpl;
import com.akvelon.bicycleProject.model.Bike;
import com.akvelon.bicycleProject.service.impl.BikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */

@RestController
public class HomeController {

    @Autowired
    BikeServiceImpl bikeService;

    @RequestMapping("/bike/getAll")
    public List<Bike> getAllBikes(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
        List<Bike> bikeList = bikeService.getAll();
        return bikeList;
    }

    @RequestMapping(value = "bike/get/{id}", method = RequestMethod.GET)
    public Bike getByID(@PathVariable("id") String id) {
        return bikeService.getById(Integer.parseInt(id));
    }

    @RequestMapping(value = "bike/get/{fieldName}/{value}", method = RequestMethod.GET)
    public List<Bike> getBy(@PathVariable("fieldName") String fieldName,@PathVariable("value") String value){
        System.out.println(fieldName + value);
        List<Bike> bikeList = bikeService.getBy(fieldName, value);
        return bikeList;
    }

    @RequestMapping(value = "bike/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        bikeService.delete(Integer.parseInt(id));
    }
}
