package com.lti.flipshop.flipkart.exeception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Integer id){
        super("No order found with orderID :  " + id );
    }

}
