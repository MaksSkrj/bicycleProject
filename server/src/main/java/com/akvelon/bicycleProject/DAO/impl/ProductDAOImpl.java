package com.akvelon.bicycleProject.DAO.impl;

import com.akvelon.bicycleProject.DAO.api.DAO;
import com.akvelon.bicycleProject.DAO.api.ProductDAO;
import com.akvelon.bicycleProject.mapper.ProductMapper;
import com.akvelon.bicycleProject.model.Clazz;
import com.akvelon.bicycleProject.model.Product;
import com.akvelon.bicycleProject.model.ProductLine;
import com.akvelon.bicycleProject.model.Style;
import com.mysql.fabric.xmlrpc.base.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static com.akvelon.bicycleProject.DAO.impl.SQLs.*;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {
    private String classType = "product";

    @Override
    public List<Product> getAll() {
        String sql = String.format(SELECT_ALL, classType);
        List<Product> bikes = getJdbcTemplate().query(sql, new ProductMapper());
        return bikes;
    }

    @Override
    public Product getById(Integer id) {
        String sql = String.format(FIND_PRODUCT_BY_ID, classType);
        Product product = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new ProductMapper());
        return product;
    }

    @Override
    public List<Product> getBy(String fieldName, String value) {
        String sql = String.format(FIND_BY, classType, fieldName);
        List<Product> products = getJdbcTemplate().query(sql, new Object[]{value}, new ProductMapper());
        return products;
    }

    @Override
    public void delete(Integer id) {
        String sql = String.format(DELETE_PRODUCT_BY_ID, classType);
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(Product product, String id) {
        Object[] properties = new Object[]{product.getName(), product.getProductNumber(), product.getColor(), product.getSafetyStockLevel(),
                product.getReorderPoint(), product.getStandardCost(), product.getListPrice(), product.getSize(), product.getWeight(), product.getProductLine().toString(),
                product.getClazz().toString(), product.getStyle().toString(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), id};
        getJdbcTemplate().update(UPDATE_PRODUCT, properties);
    }

    @Override
    public void insert(Product product) {
        Object[] properties = new Object[]{product.getName(), product.getProductNumber(), product.getColor(), product.getSafetyStockLevel(),
                product.getReorderPoint(), product.getStandardCost(), product.getListPrice(), product.getSize(), product.getWeight(), product.getProductLine().toString(),
                product.getClazz().toString(), product.getStyle().toString(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())};
        getJdbcTemplate().update(INSERT_PRODUCT, properties);
    }

    @Override
    public List<Product> getTopFive() {
        return getJdbcTemplate().query(GET_TOP_FIVE_BIKES, new ProductMapper());
    }

    @Override
    public List<Product> productSearch(String searchRequest) {
        String sql = String.format(PRODUCT_SEARCH, searchRequest);
        return getJdbcTemplate().query(sql, new ProductMapper());
    }
}
