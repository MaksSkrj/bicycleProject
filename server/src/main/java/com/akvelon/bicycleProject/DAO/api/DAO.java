package com.akvelon.bicycleProject.DAO.api;

import com.akvelon.bicycleProject.model.Entity;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */
public interface DAO<T> {
    //Select all Objects from table
    public List<T> getAll();

    //Select one Object from table using ID
    public T getById(Integer id);

    //Selecting all Objects from table where field value == value
    public List<T> getBy(String fieldName, String value);

    //Deleting Object from table using ID
    public void delete(Integer id);
}
