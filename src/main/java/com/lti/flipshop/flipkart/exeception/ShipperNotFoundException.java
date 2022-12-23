package com.lti.flipshop.flipkart.exeception;

public class ShipperNotFoundException extends RuntimeException{
    public ShipperNotFoundException(Integer id){
        super("Shipper not found with shipper id : " + id);
    }
}
