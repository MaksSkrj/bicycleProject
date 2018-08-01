package com.akvelon.bicycleProject.DAO.impl;

/**
 * Created by maksym.skrypnyk
 */
public class SQLs {

    //SELECT All products WHERE FinishedGoodsFlag = 1
    public static final String SELECT_ALL = "SELECT * FROM %s WHERE FinishedGoodsFlag = 1";

    //SELECT products BY selected column WHERE FinishedGoodsFlag = 1
    public static final String FIND_BY = "Select * FROM %s WHERE %s = ? AND FinishedGoodsFlag = 1";

    //SELECT products BY ID
    public static final String FIND_PRODUCT_BY_ID = "SELECT * FROM %s WHERE ProductID = ? ";

    //CHANGING FinishedGoodsFlag on '0'
    public static final String DELETE_PRODUCT_BY_ID = "UPDATE %s SET FinishedGoodsFlag = 0 WHERE ProductID = ?";

    //INSERTING new product
    public static final String INSERT_PRODUCT = "Insert into Product (Name, ProductNumber, MakeFlag, FinishedGoodsFlag, Color, SafetyStockLevel, ReorderPoint, " +
            "StandardCost, ListPrice, Size, Weight, DaysToManufacture, ProductLine, Class, Style, SellStartDate, rowguid, ModifiedDate) " +
            "values (?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, 0xD2AE219CFA5B184FBCB8F11638DC2E4E, ?)";

    //UPDATING product
    // getting Product object from JSON and product ID
    public static final String UPDATE_PRODUCT = "UPDATE product SET Name = ?, ProductNumber = ?, MakeFlag = 0, FinishedGoodsFlag = ?, Color = ?, SafetyStockLevel = ?, ReorderPoint = ?, " +
            "StandardCost = ?, ListPrice = ?, Size = ?, Weight = ?, DaysToManufacture = 0, ProductLine = ?, Class = ?, Style = ?, SellStartDate = ?," +
            " rowguid = 0xD2AE219CFA5B184FBCB8F11638DC2E4E, ModifiedDate = ? WHERE ProductID = ?";

    //SELECT top five bikes WHERE FinishedGoodsFlag = 1
    public static final String GET_TOP_FIVE_BIKES = "SELECT * FROM product JOIN transactionhistoryarchive ON product.ProductID = transactionhistoryarchive.ProductID \n" +
            "JOIN productsubcategory ON product.ProductSubcategoryID = productsubcategory.ProductSubcategoryID \n" +
            "WHERE productsubcategory.ProductCategoryID = 1 AND FinishedGoodsFlag = 1 GROUP BY product.ProductID ORDER BY count(*) DESC LIMIT 5 ";

    //SEARCHING product
    public static final String PRODUCT_SEARCH = "SELECT * FROM product WHERE Name LIKE \"%%%s%%\"";

    //SELECT ProductPhoto using ProductID
    public static final String SELECT_PRODUCT_PHOTO_BY_PRODUCT_ID = "SELECT * FROM ProductPhoto LEFT JOIN ProductProductPhoto ON " +
            "ProductPhoto.ProductPhotoID = ProductProductPhoto.ProductPhotoID WHERE ProductID = ?";

}