package com.akvelon.bicycleProject.DAO.impl;

import com.akvelon.bicycleProject.DAO.api.DAO;
import org.springframework.stereotype.Component;
import com.akvelon.bicycleProject.mapper.BikeMapper;
import com.akvelon.bicycleProject.model.Bike;

import java.util.List;

import static com.akvelon.bicycleProject.DAO.impl.SQLs.*;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class BikeDAOImpl  extends AbstractDAO implements DAO {
    private final String classType = "bike";

    @Override
    public List<Bike> getAll() {
        String sql = String.format(SELECT_ALL, classType);
        List<Bike> bikes = getJdbcTemplate().query(sql, new BikeMapper());
        return bikes;
    }

    @Override
    public Bike getById(Integer id) {
        String sql = String.format(FIND_BY_ID, classType);
        Bike bike = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new BikeMapper());
        return bike;

    }

    @Override
    public List<Bike> getBy(String fieldName, String value) {
        String sql = String.format(FIND_BY, classType, fieldName);
        List<Bike> bikes = getJdbcTemplate().query(sql, new Object[]{value}, new BikeMapper());
        return bikes;

    }

    @Override
    public void delete(Integer id) {
        String sql = String.format(DELETE_BY_ID, classType);
        getJdbcTemplate().update(sql, id);
    }


    public void update(String name, String colour, double weight, int type_id, int manufacturer_id, double price, int views, int id) {
        Object[] properties = new Object[]{name, colour, weight, type_id, manufacturer_id, price, views, id};
        getJdbcTemplate().update(UPDATE_BIKE, properties);
    }


    public void insert(String name, String colour, double weight, int type_id, int manufacturer_id, double price, int views) {
        Object[] properties = new Object[]{name, colour, weight, type_id, manufacturer_id, price, views};
        getJdbcTemplate().update(INSERT_BIKE, properties);
    }
}
