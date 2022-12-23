package com.lti.flipshop.flipkart.entity;

import javax.persistence.*;

@Entity
@Table(name = "products_10708661")
public class Product {
    @Id
    private int productID;

    @ManyToOne
    @JoinColumn(name = "supplierID")
    Supplier supplier;

    private int unit, price;
    private String productName;

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
