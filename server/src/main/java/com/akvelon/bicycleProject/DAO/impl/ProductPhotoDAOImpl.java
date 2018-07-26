package com.akvelon.bicycleProject.DAO.impl;

import com.akvelon.bicycleProject.DAO.api.DAO;
import com.akvelon.bicycleProject.mapper.ProductPhotoMapper;
import com.akvelon.bicycleProject.model.ProductPhoto;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.akvelon.bicycleProject.DAO.impl.SQLs.SELECT_PRODUCT_PHOTO_BY_PRODUCT_ID;

/**
 * Created by maksym.skrypnyk
 */


@Component
public class ProductPhotoDAOImpl extends AbstractDAO {

    public List<ProductPhoto> getPhotoByProductId(int productId) {
        List<ProductPhoto> productPhotoList = getJdbcTemplate().query(SELECT_PRODUCT_PHOTO_BY_PRODUCT_ID, new Object[]{productId}, new ProductPhotoMapper());
        return productPhotoList;
    }

}
