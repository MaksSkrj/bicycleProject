package com.akvelon.bicycleProject.DAO.impl;

/**
 * Created by maksym.skrypnyk
 */
public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";

    public static final String INSERT_BIKE = "Insert into bike (name, colour, weight, type_id, manufacturer_id, price, views) values (?,?,?,?,?,?,?)";
    public static final String UPDATE_BIKE = "UPDATE bike SET name = ?, colour = ?, weight = ?, type_id = ?, manufacturer_id = ? , price = ?, views = ? WHERE id = ?";

    public static final String INSERT_TYPE = "Insert into type (name, description) values (?,?)";
    public static final String UPDATE_TYPE = "UPDATE type SET name = ?, description = ? WHERE id = ?";

    public static final String INSERT_MANUFACTURER = "Insert into manufacturer (name, country, year_of_foundation, web_site) values (?,?,?,?)";
    public static final String UPDATE_MANUFACTURER = "UPDATE manufacturer SET name = ?, country = ?, year_of_foundation = ?, web_site = ? WHERE id = ?";
}
