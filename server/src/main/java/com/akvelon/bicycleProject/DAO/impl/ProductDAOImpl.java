package com.akvelon.bicycleProject.DAO.impl;

import com.akvelon.bicycleProject.DAO.api.ProductDAO;
import com.akvelon.bicycleProject.mapper.ProductMapper;
import com.akvelon.bicycleProject.model.Counter;
import com.akvelon.bicycleProject.model.Product;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

import static com.akvelon.bicycleProject.DAO.impl.SQLs.*;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {
    private String classType = "product";
    private int from = 0;  // Start point for Requests with lot of products
    private final int STEP = 20;  // How much products will be returned from one request
    private Counter counter = Counter.UNDEFINED;
    private String searchString = "";  //Using to check if searching request will change

    @Override
    public List<Product> getAll() {
        if (counter != Counter.GET_ALL){
            from = 0;
            counter = Counter.GET_ALL;
        }
        String sql = String.format(SELECT_ALL, classType, from, STEP);
        List<Product> bikes = getJdbcTemplate().query(sql, new ProductMapper());
        from+= STEP;
        return bikes;
    }

    @Override
    public Product getById(Integer id) {
        String sql = String.format(FIND_PRODUCT_BY_ID, classType);
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new ProductMapper());
    }

    @Override
    public List<Product> getBy(String fieldName, String value) {
        String sql = String.format(FIND_BY, classType, fieldName);
        return getJdbcTemplate().query(sql, new Object[]{value}, new ProductMapper());
    }

    @Override
    public boolean delete(Integer id) {
        String sql = String.format(DELETE_PRODUCT_BY_ID, classType);
        getJdbcTemplate().update(sql, id);
        return true;
    }

    @Override
    public boolean update(Product product, String id) {
        Object[] properties = new Object[]{product.getName(), product.getProductNumber(), product.getColor(), product.getSafetyStockLevel(),
                product.getReorderPoint(), product.getStandardCost(), product.getListPrice(), product.getSize(), product.getWeight(), product.getProductLine().toString(),
                product.getClazz().toString(), product.getStyle().toString(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), id};
        getJdbcTemplate().update(UPDATE_PRODUCT, properties);
        return true;
    }

    @Override
    public boolean insert(Product product) {
        Object[] properties = new Object[]{product.getName(), product.getProductNumber(), product.getFinishedFoodsFlag(), product.getColor(), product.getSafetyStockLevel(),
                product.getReorderPoint(), product.getStandardCost(), product.getListPrice(), product.getSize(), product.getWeight(), product.getProductLine().toString(),
                product.getClazz().toString(), product.getStyle().toString(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())};
        getJdbcTemplate().update(INSERT_PRODUCT, properties);
        return true;
    }

    @Override
    public List<Product> getTopFive() {
        from = 0;
        return getJdbcTemplate().query(GET_TOP_FIVE_BIKES, new ProductMapper());
    }

    @Override
    public List<Product> productSearch(String searchRequest) {
        if (counter != Counter.SEARCH || !searchString.equals(searchRequest)){  //checking previous requests and search value
            from = 0;
            searchString = searchRequest;
            counter = Counter.SEARCH;
        }
        String sql = String.format(PRODUCT_SEARCH, searchRequest, from, STEP);
        List<Product> productList = getJdbcTemplate().query(sql, new ProductMapper());
        from+= STEP;
        return productList;
    }
}
