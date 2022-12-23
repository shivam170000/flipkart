package com.lti.flipshop.flipkart.handler;


import com.lti.flipshop.flipkart.exeception.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class HandlerClass {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException){
        StringBuilder sb = new StringBuilder();
        methodArgumentNotValidException.getFieldErrors().forEach(error-> sb.append(error.getDefaultMessage()).append("\n"));
        return new ResponseEntity<>(sb.toString(), HttpStatus.valueOf(406));
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    ResponseEntity<String> customerAlreadyExist(CustomerAlreadyExistException customerAlreadyExistException){
        return new ResponseEntity<>(customerAlreadyExistException.getMessage(), HttpStatus.valueOf(403));
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<String> customerNotFound(CustomerNotFoundException customerNotFoundException){
        return new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.valueOf(404));
    }

    @ExceptionHandler(OrderNotFoundException.class)
    ResponseEntity<String> orderNotFound(OrderNotFoundException orderNotFoundException){
        return new ResponseEntity<>(orderNotFoundException.getMessage(),HttpStatus.valueOf(404));
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    ResponseEntity<String> productAlreadyExist(ProductAlreadyExistException productAlreadyExistException){
        return new ResponseEntity<>(productAlreadyExistException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<String> productNotFound(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(),HttpStatus.valueOf(404));
    }

    @ExceptionHandler(ShipperNotFoundException.class)
    ResponseEntity<String> shipperNotFound(ShipperNotFoundException shipperNotFoundException){
        return new ResponseEntity<>(shipperNotFoundException.getMessage(), HttpStatus.valueOf(404));
    }



}
