package com.akvelon.bicycleProject.service.impl;

import com.akvelon.bicycleProject.DAO.impl.BikeDAOImpl;
import com.akvelon.bicycleProject.model.Bike;
import com.akvelon.bicycleProject.service.api.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class BikeServiceImpl implements BikeService {
    @Autowired
    BikeDAOImpl bikeDAO;


    @Override
    public List<Bike> searchByExpression(String expression) {
        return null;
    }

    @Override
    public List<Bike> getTopFive() {
        return null;
    }

    @Override
    public List<Bike> getAll() {
        return bikeDAO.getAll();
    }

    @Override
    public Bike getById(Integer id) {
        return bikeDAO.getById(id);
    }

    @Override
    public List<Bike> getBy(String fieldName, String value) {
        return bikeDAO.getBy(fieldName, value);
    }

    @Override
    public void delete(Integer id) {
        bikeDAO.delete(id);
    }

    public void update(String name, String colour, double weight, int type_id, int manufacturer_id, double price, int views, int id){
        bikeDAO.update(name, colour, weight, type_id, manufacturer_id, price, views, id);
    }

    public void insert(String name, String colour, double weight, int type_id, int manufacturer_id, double price, int views) {
        bikeDAO.insert(name, colour, weight, type_id, manufacturer_id, price, views);
    }
}
