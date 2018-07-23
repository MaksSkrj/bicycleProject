package com.akvelon.bicycleProject.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.akvelon.bicycleProject.model.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by maksym.skrypnyk
 */


public class ManufacturerMapper implements RowMapper<Manufacturer> {
    public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(rs.getString("name"));
        manufacturer.setCountry(rs.getString("country"));
        manufacturer.setYearOfFoundation(rs.getInt("year_of_foundation"));
        manufacturer.setWebSite(rs.getString("web_site"));

        return manufacturer;
    }
}
