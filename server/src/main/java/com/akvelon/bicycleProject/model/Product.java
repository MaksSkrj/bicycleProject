package com.akvelon.bicycleProject.model;

import java.util.Date;
import java.util.List;

/**
 * Created by maksym.skrypnyk
 */

public class Product {
    private int productId;
    private String name;
    private String productNumber;
    private int finishedFoodsFlag;
    private String color;
    private int safetyStockLevel;
    private int reorderPoint;
    private double standardCost;
    private double listPrice;
    private String size;
    private double weight;
    private ProductLine productLine;
    private Clazz clazz;
    private Style style;
    private Date modifiedDate;

    public Product() {

    }

    public Product(int productId, String name, String productNumber, int finishedFoodsFlag, String color, int safetyStockLevel, int reorderPoint, double standartCost, double listPrice, String size, double weight, ProductLine productLine, Clazz clazz, Style style, Date modifiedDate) {
        this.productId = productId;
        this.name = name;
        this.productNumber = productNumber;
        this.finishedFoodsFlag = finishedFoodsFlag;
        this.color = color;
        this.safetyStockLevel = safetyStockLevel;
        this.reorderPoint = reorderPoint;
        this.standardCost = standartCost;
        this.listPrice = listPrice;
        this.size = size;
        this.weight = weight;
        this.productLine = productLine;
        this.clazz = clazz;
        this.style = style;
        this.modifiedDate = modifiedDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getFinishedFoodsFlag() {
        return finishedFoodsFlag;
    }

    public void setFinishedFoodsFlag(int finishedFoodsFlag) {
        this.finishedFoodsFlag = finishedFoodsFlag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public void setSafetyStockLevel(int safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public double getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(double standardCost) {
        this.standardCost = standardCost;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", finishedFoodsFlag=" + finishedFoodsFlag +
                ", color='" + color + '\'' +
                ", safetyStockLevel=" + safetyStockLevel +
                ", reorderPoint=" + reorderPoint +
                ", standardCost=" + standardCost +
                ", listPrice=" + listPrice +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                ", productLine=" + productLine +
                ", clazz=" + clazz +
                ", style=" + style +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
