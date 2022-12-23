package com.lti.flipshop.flipkart.exeception;

public class ProductAlreadyExistException extends RuntimeException{

    public ProductAlreadyExistException(Integer pid){
        super("Product already exist with : " + pid);
    }

}
