package com.akvelon.bicycleProject.controllers;


import com.akvelon.bicycleProject.model.Product;
import com.akvelon.bicycleProject.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/bike/getAll")
    public List<Product> getAllProducts() {
        return productService.getAll();
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

    @RequestMapping("bike/search/{searchRequest}")
    public List<Product> search(@PathVariable("searchRequest") String searchRequest) {
        return productService.productSearch(searchRequest);
    }

    @RequestMapping(value = "bike/insert", method = RequestMethod.POST)
    public boolean insertProduct(@RequestBody Product product) {
        return productService.insert(product);
    }

    @RequestMapping("/bike/update/{id}")
    public boolean updateProduct(@RequestBody Product product, @PathVariable("id") String id) {
        return productService.update(product, id);
    }

    @RequestMapping("bike/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return productService.delete(Integer.parseInt(id));
    }


}
