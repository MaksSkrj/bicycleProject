package com.akvelon.bicycleProject.DAO.impl;

/**
 * Created by maksym.skrypnyk
 */
public class SQLs {

    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY = "Select * from %s where %s = ?";



    public static final String FIND_PRODUCT_BY_ID = "Select * from %s where ProductID = ?";
    public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM %s WHERE ProductID = ?";

    public static final String INSERT_PRODUCT = "Insert into Product (Name, ProductNumber, MakeFlag, FinishedGoodsFlag, Color, SafetyStockLevel, ReorderPoint, " +
            "StandardCost, ListPrice, Size, Weight, DaysToManufacture, ProductLine, Class, Style, SellStartDate, rowguid, ModifiedDate) " +
            "values (?, ?, 0, 0, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, 0xD2AE219CFA5B184FBCB8F11638DC2E4E, ?)";

    public static final String UPDATE_PRODUCT = "UPDATE product SET Name = ?, ProductNumber = ?, MakeFlag = 0, FinishedGoodsFlag = 0, Color = ?, SafetyStockLevel = ?, ReorderPoint = ?, " +
            "StandardCost = ?, ListPrice = ?, Size = ?, Weight = ?, DaysToManufacture = 0, ProductLine = ?, Class = ?, Style = ?, SellStartDate = ?," +
            " rowguid = 0xD2AE219CFA5B184FBCB8F11638DC2E4E, ModifiedDate = ? WHERE ProductID = ?";

    public static final String GET_TOP_FIVE_BIKES = "SELECT * FROM product \n" +
            "JOIN transactionhistoryarchive ON product.ProductID = transactionhistoryarchive.ProductID \n" +
            "JOIN productsubcategory ON product.ProductSubcategoryID = productsubcategory.ProductSubcategoryID \n" +
            "WHERE productsubcategory.ProductCategoryID = 1 GROUP BY product.ProductID ORDER BY count(*) DESC LIMIT 5";

    public static final String PRODUCT_SEARCH = "SELECT * FROM product WHERE Name LIKE \"%%%s%%\"";

}