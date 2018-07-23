package com.akvelon.bicycleProject.DAO.impl;

import com.akvelon.bicycleProject.DAO.api.DAO;
import com.akvelon.bicycleProject.mapper.ManufacturerMapper;
import com.akvelon.bicycleProject.model.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.akvelon.bicycleProject.DAO.impl.SQLs.*;

/**
 * Created by maksym.skrypnyk
 */


@Component
public class ManufacturerDAOImpl extends AbstractDAO implements DAO {
    private final String classType = "manufacturer";

    @Override
    public List<Manufacturer> getAll() {
        String sql = String.format(SELECT_ALL, classType);
        List<Manufacturer> manufacturers = getJdbcTemplate().query(sql, new ManufacturerMapper());
        return manufacturers;
    }

    @Override
    public Manufacturer getById(Integer id) {
        String sql = String.format(FIND_BY_ID, classType);
        Manufacturer manufacturer = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new ManufacturerMapper());
        return manufacturer;
    }

    @Override
    public List<Manufacturer> getBy(String fieldName, String value) {
        String sql = String.format(FIND_BY, classType, fieldName);
        List<Manufacturer> manufacturers = getJdbcTemplate().query(sql, new Object[]{value}, new ManufacturerMapper());
        return manufacturers;
    }

    @Override
    public void delete(Integer id) {
        String sql = String.format(DELETE_BY_ID, classType);
        getJdbcTemplate().update(sql, id);
    }

    public void update(String name, String country, Integer year_of_foundation, String web_site) {
        Object[] properties = new Object[]{name, country, year_of_foundation, web_site};
        getJdbcTemplate().update(UPDATE_MANUFACTURER, properties);
    }


    public void insert(String name, String country, Integer year_of_foundation, String web_site) {
        Object[] properties = new Object[]{name, country, year_of_foundation, web_site};
        getJdbcTemplate().update(INSERT_MANUFACTURER, properties);
    }
}
