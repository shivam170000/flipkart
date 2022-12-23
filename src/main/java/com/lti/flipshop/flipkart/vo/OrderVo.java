package com.lti.flipshop.flipkart.vo;

import com.lti.flipshop.flipkart.vo.OrderDetailVo;

import javax.validation.constraints.*;
import java.util.*;

public class OrderVo {

    @NotNull(message = "Enter customerID !")
    private int customerID;
    @NotBlank(message="enter date")
    @Size(min = 10 , max = 10 , message = "Invalid date")
    private String Date;

    @NotNull(message = "provide shipper id")
    private int shipperID;

    @NotEmpty(message="Before placing order select products")
    private List<OrderDetailVo> orderDetails;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public List<OrderDetailVo> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailVo> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
