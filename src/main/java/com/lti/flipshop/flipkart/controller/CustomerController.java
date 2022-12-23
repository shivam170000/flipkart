package com.lti.flipshop.flipkart.controller;

import com.lti.flipshop.flipkart.entity.Customer;
import com.lti.flipshop.flipkart.service.CustomerService;
import com.lti.flipshop.flipkart.validation.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.lti.flipshop.flipkart.exeception.CustomerAlreadyExistException;
import com.lti.flipshop.flipkart.exeception.CustomerNotFoundException;
import com.lti.flipshop.flipkart.vo.CustomerVo;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:9090")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/api/v1/customer")
    ResponseEntity<List<Customer>> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/api/v1/customer")
    ResponseEntity<String> addCustomer(@RequestBody @Valid ValidList<CustomerVo> customers)  {
        customerService.addCustomer(customers);
        return new ResponseEntity<>("CUSTOMER ADDED",HttpStatus.OK);
    }

    @PutMapping("/api/v1/customer")
    ResponseEntity<String> updateCustomer(@RequestBody List<CustomerVo> customers)  {
        customerService.updateCustomer(customers);
        return new ResponseEntity<>("CUSTOMER UPDATED", HttpStatus.OK);
    }


}
