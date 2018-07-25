package com.akvelon.bicycleProject.service.api;

import com.akvelon.bicycleProject.model.Product;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


public interface ProductService extends Service<Product> {
    List<Product> productSearch(String expression);

    List<Product> getTopFive();

}
