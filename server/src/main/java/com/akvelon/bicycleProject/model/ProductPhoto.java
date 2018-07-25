package com.akvelon.bicycleProject.model;


import java.util.Date;

/**
 * Created by maksym.skrypnyk
 */

public class ProductPhoto{
    private int productPhotoID;
    private byte[] thumbNailPhoto;
    private String thumbnailPhotoFileName;
    private byte[] largePhoto;
    private String largePhotoFileName;
    private Date modifiedDate;

    public ProductPhoto(){

    }

    public ProductPhoto(int productPhotoID, byte[] thumbNailPhoto, String thumbnailPhotoFileName, byte[] largePhoto, String largePhotoFileName, Date modifiedDate) {
        this.productPhotoID = productPhotoID;
        this.thumbNailPhoto = thumbNailPhoto;
        this.thumbnailPhotoFileName = thumbnailPhotoFileName;
        this.largePhoto = largePhoto;
        this.largePhotoFileName = largePhotoFileName;
        this.modifiedDate = modifiedDate;
    }

    public int getProductPhotoID() {
        return productPhotoID;
    }

    public void setProductPhotoID(int productPhotoID) {
        this.productPhotoID = productPhotoID;
    }

    public byte[] getThumbNailPhoto() {
        return thumbNailPhoto;
    }

    public void setThumbNailPhoto(byte[] thumbNailPhoto) {
        this.thumbNailPhoto = thumbNailPhoto;
    }

    public String getThumbnailPhotoFileName() {
        return thumbnailPhotoFileName;
    }

    public void setThumbnailPhotoFileName(String thumbnailPhotoFileName) {
        this.thumbnailPhotoFileName = thumbnailPhotoFileName;
    }

    public byte[] getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(byte[] largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoFileName() {
        return largePhotoFileName;
    }

    public void setLargePhotoFileName(String largePhotoFileName) {
        this.largePhotoFileName = largePhotoFileName;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "ProductPhoto{" +
                "productPhotoID=" + productPhotoID +
                ", thumbNailPhoto=" + thumbNailPhoto +
                ", thumbnailPhotoFileName='" + thumbnailPhotoFileName + '\'' +
                ", largePhoto=" + largePhoto +
                ", largePhotoFileName='" + largePhotoFileName + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
