package com.akvelon.bicycleProject.controllers;


import com.akvelon.bicycleProject.model.Product;
import com.akvelon.bicycleProject.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.akvelon.bicycleProject.model.Clazz.L;
import static com.akvelon.bicycleProject.model.ProductLine.T;
import static com.akvelon.bicycleProject.model.Style.M;


/**
 * Created by maksym.skrypnyk
 */

@RestController
public class HomeController {

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/bike/getAll")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @RequestMapping("/bike/insert")
    public void insertProduct() {
        productService.insert("FIRST", "adfdsfsdf", "PURPLE", 213, 213, 100., 12321321., "BIG", 10., T, L, M);
    }

    @RequestMapping("/bike/update/{id}")
    public void updateProduct(@PathVariable("id") String id) {
        productService.update("FIRST", "UPDATED", "PURPLE", 213, 213, 100., 123, "BIG", 10., T, L, M, id);
    }

    @RequestMapping("bike/get/{id}")
    public Product getById(@PathVariable("id") String id) {
        return productService.getById(Integer.parseInt(id));
    }

    @RequestMapping(value = "bike/get/{fieldName}/{value}", method = RequestMethod.GET)
    public List<Product> getBy(@PathVariable("fieldName") String fieldName, @PathVariable("value") String value) {
        return productService.getBy(fieldName, value);
    }

    @RequestMapping("/bike/getTop")
    public List<Product> getTopFive() {
        return productService.getTopFive();
    }

    @RequestMapping("bike/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        productService.delete(Integer.parseInt(id));
    }

    @RequestMapping("bike/search/{searchRequest}")
    public List<Product> search(@PathVariable("searchRequest") String searchRequest) {
        return productService.productSearch(searchRequest);
    }
}
