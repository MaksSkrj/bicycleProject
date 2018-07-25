package com.akvelon.bicycleProject.mapper;

import com.akvelon.bicycleProject.model.*;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by maksym.skrypnyk
 */


public class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("ProductID"));
        product.setName(rs.getString("Name"));
        product.setProductNumber(rs.getString("ProductNumber"));
        product.setColor(rs.getString("Color"));
        product.setSafetyStockLevel(rs.getInt("SafetyStockLevel"));
        product.setReorderPoint(rs.getInt("ReorderPoint"));
        product.setStandardCost(rs.getDouble("StandardCost"));
        product.setListPrice(rs.getDouble("ListPrice"));
        product.setSize(rs.getString("Size"));
        product.setWeight(rs.getDouble("Weight"));
        String productLineString = rs.getString("ProductLine"); //productLine ENUM
        if (productLineString != null){
            product.setProductLine(ProductLine.valueOf(productLineString.trim()));
        }
        String clazzString = rs.getString("Class"); //clazz ENUM
        if(clazzString != null){
            product.setClazz(Clazz.valueOf(clazzString.trim()));
        }
        String styleString = rs.getString("Style"); //style ENUM
        if(styleString != null){
            product.setStyle(Style.valueOf(styleString.trim()));
        }
        product.setModifiedDate(rs.getDate("ModifiedDate"));


        return product;
    }
}
