package com.lti.flipshop.flipkart.exeception;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(Integer id){
        super("Customer already exists with id: " + id);
    }
}
