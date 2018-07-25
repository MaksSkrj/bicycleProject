package com.akvelon.bicycleProject.service.impl;

import com.akvelon.bicycleProject.DAO.impl.ProductDAOImpl;
import com.akvelon.bicycleProject.model.Clazz;
import com.akvelon.bicycleProject.model.Product;
import com.akvelon.bicycleProject.model.ProductLine;
import com.akvelon.bicycleProject.model.Style;
import com.akvelon.bicycleProject.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAOImpl productDAO;


    @Override
    public List<Product> productSearch(String searchRequest) {
        return productDAO.productSearch(searchRequest);
    }

    @Override
    public List<Product> getTopFive() {
        return productDAO.getTopFive();
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product getById(Integer id) {
        return productDAO.getById(id);
    }

    @Override
    public List<Product> getBy(String fieldName, String value) {
        return productDAO.getBy(fieldName, value);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }

    public void insert(String name, String productNumber, String color, int safetyStockLevel, int reorderPoint, double standardCost, double listPrice, String size, double weight, ProductLine productLine, Clazz clazz, Style style){
        productDAO.insert(name, productNumber, color, safetyStockLevel, reorderPoint, standardCost, listPrice, size, weight, productLine, clazz, style);
    }

    public void update(String name, String productNumber, String color, int safetyStockLevel, int reorderPoint, double standardCost, double listPrice, String size, double weight, ProductLine productLine, Clazz clazz, Style style, String id){
        productDAO.update(name, productNumber, color, safetyStockLevel, reorderPoint, standardCost, listPrice, size, weight, productLine, clazz, style, id);
    }
}