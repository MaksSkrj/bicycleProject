package com.akvelon.bicycleProject.DAO.api;

import com.akvelon.bicycleProject.model.Product;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


public interface ProductDAO extends DAO<Product> {

    void update(Product product, String id);

    void insert(Product product);

    List<Product> getTopFive();

    List<Product> productSearch(String searchRequest);
}
