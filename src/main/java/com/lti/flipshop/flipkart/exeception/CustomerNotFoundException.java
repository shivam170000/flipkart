package com.lti.flipshop.flipkart.exeception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Integer id){
        super("No customer found with id: "+id);
    }
}
