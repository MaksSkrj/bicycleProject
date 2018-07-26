package com.akvelon.bicycleProject.mapper;

import com.akvelon.bicycleProject.model.ProductPhoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by maksym.skrypnyk
 */


public class ProductPhotoMapper implements RowMapper<ProductPhoto> {
    public ProductPhoto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setProductPhotoID(rs.getInt("ProductPhotoID"));
        productPhoto.setThumbNailPhoto(rs.getBytes("ThumbNailPhoto"));
        productPhoto.setThumbnailPhotoFileName(rs.getString("ThumbnailPhotoFileName"));
        productPhoto.setLargePhoto(rs.getBytes("LargePhoto"));
        productPhoto.setLargePhotoFileName(rs.getString("LargePhotoFileName"));
        productPhoto.setModifiedDate(rs.getDate("ModifiedDate"));

        return productPhoto;
    }
}
