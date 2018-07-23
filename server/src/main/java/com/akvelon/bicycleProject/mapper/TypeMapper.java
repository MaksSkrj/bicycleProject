package com.akvelon.bicycleProject.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.akvelon.bicycleProject.model.Type;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by maksym.skrypnyk
 */


public class TypeMapper implements RowMapper<Type> {
    public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type();
        type.setName(rs.getString("name"));
        type.setDescription(rs.getString("description"));

        return type;
    }
}
