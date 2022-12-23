package com.lti.flipshop.flipkart.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDetailVo {

    @NotNull(message = "Quantity must be greater than 0")
    private int quantity;
    @NotNull(message = "select the product")
    private int productID;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
