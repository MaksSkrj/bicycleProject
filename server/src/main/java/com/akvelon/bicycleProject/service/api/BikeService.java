package com.akvelon.bicycleProject.service.api;

import com.akvelon.bicycleProject.model.Bike;
import com.akvelon.bicycleProject.service.api.Service;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


public interface BikeService extends Service<Bike> {
    List<Bike> searchByExpression(String expression);

    List<Bike> getTopFive();
}
