package com.akvelon.bicycleProject.service.api;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


public interface Service<T> {
    List<T> getAll();

    public T getById(Integer id);

    public List<T> getBy(String fieldName, String value);

    public boolean delete(Integer id);


}
