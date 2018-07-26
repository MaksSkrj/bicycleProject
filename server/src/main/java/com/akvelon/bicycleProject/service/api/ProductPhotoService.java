package com.akvelon.bicycleProject.service.api;

import com.akvelon.bicycleProject.model.ProductPhoto;

import java.util.List;

/**
 * Created by maksym.skrypnyk
 */


public interface ProductPhotoService {

    List<ProductPhoto> getPhotoByProductId(int productId);
}
