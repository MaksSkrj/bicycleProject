package com.akvelon.bicycleProject.controllers;

import com.akvelon.bicycleProject.model.ProductPhoto;
import com.akvelon.bicycleProject.service.impl.ProductPhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


@CrossOrigin(origins = "*")
@RestController
public class ProductPhotoController {
    @Autowired
    ProductPhotoServiceImpl productPhotoService;

    @RequestMapping("photo/get/{id}")
    public List<ProductPhoto> getPhotoByProductId(@PathVariable("id") String id) {
        return productPhotoService.getPhotoByProductId(Integer.parseInt(id));
    }
}
