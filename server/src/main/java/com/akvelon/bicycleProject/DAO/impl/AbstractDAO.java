package com.akvelon.bicycleProject.DAO.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by maksym.skrypnyk
 */

@
        Component
public abstract class AbstractDAO {

    @Autowired
    private JdbcTemplate getJdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return getJdbcTemplate;
    }
}
