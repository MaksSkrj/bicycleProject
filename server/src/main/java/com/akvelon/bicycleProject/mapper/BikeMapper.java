package com.akvelon.bicycleProject.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.akvelon.bicycleProject.model.Bike;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by maksym.skrypnyk
 */
public class BikeMapper implements RowMapper<Bike> {
    public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bike bike = new Bike();
        bike.setName(rs.getString("name"));
        bike.setColour(rs.getString("colour"));
        bike.setWeight(rs.getDouble("weight"));
        bike.setType_id(rs.getInt("type_id"));
        bike.setManufacturer_id(rs.getInt("manufacturer_id"));
        bike.setPrice(rs.getDouble("price"));
        bike.setViews(rs.getInt("views"));

        return bike;
    }
}
