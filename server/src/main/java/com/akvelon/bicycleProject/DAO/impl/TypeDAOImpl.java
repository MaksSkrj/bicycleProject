package com.akvelon.bicycleProject.DAO.impl;

import com.akvelon.bicycleProject.DAO.api.DAO;
import com.akvelon.bicycleProject.mapper.TypeMapper;
import com.akvelon.bicycleProject.model.Type;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.akvelon.bicycleProject.DAO.impl.SQLs.*;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class TypeDAOImpl extends AbstractDAO implements DAO {
        private final String classType = "type";

        @Override
        public List<Type> getAll() {
            String sql = String.format(SELECT_ALL, classType);
            List<Type> types = getJdbcTemplate().query(sql, new TypeMapper());
            return types;
        }

        @Override
        public Type getById(Integer id) {
            String sql = String.format(FIND_BY_ID, classType);
            Type type = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new TypeMapper());
            return type;
        }

        @Override
        public List<Type> getBy(String fieldName, String value) {
            String sql = String.format(FIND_BY, classType, fieldName);
            List<Type> types = getJdbcTemplate().query(sql, new Object[]{value}, new TypeMapper());
            return types;
        }

        @Override
        public void delete(Integer id) {
            String sql = String.format(DELETE_BY_ID, classType);
            getJdbcTemplate().update(sql, id);
        }

        public void update(String name, String description) {
            Object[] properties = new Object[]{name, description};
            getJdbcTemplate().update(UPDATE_TYPE, properties);
        }


        public void insert(String name, String description) {
            Object[] properties = new Object[]{name, description};
            getJdbcTemplate().update(INSERT_TYPE, properties);
        }

    }
