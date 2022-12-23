package com.lti.flipshop.flipkart.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductVo {

    @NotNull(message = "invalid product id")
    private int productID;

    @NotNull(message = "enter units")
    private int unit;

    @NotNull(message = "enter price")
    private int price;
    @NotNull(message = "enter supplier")
    private int supplierID;
    @NotBlank(message = "Enter the productname")
    private String productName;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
