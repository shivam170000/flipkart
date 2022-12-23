package com.lti.flipshop.flipkart.exeception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Integer pid){
        super("Product not found with : " + pid);
    }

}
