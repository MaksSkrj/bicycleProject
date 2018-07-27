package com.akvelon.bicycleProject.service.impl;

import com.akvelon.bicycleProject.DAO.impl.ProductPhotoDAOImpl;
import com.akvelon.bicycleProject.model.ProductPhoto;
import com.akvelon.bicycleProject.service.api.ProductPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */

@Component
public class ProductPhotoServiceImpl implements ProductPhotoService {
    @Autowired
    ProductPhotoDAOImpl productPhotoDAO;

    @Override
    public List<ProductPhoto> getPhotoByProductId(int productId) {
        return productPhotoDAO.getPhotoByProductId(productId);
    }
}
