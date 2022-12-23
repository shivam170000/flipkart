package com.lti.flipshop.flipkart.controller;

import java.text.ParseException;
import java.util.*;
import com.lti.flipshop.flipkart.exeception.CustomerNotFoundException;
import com.lti.flipshop.flipkart.exeception.OrderNotFoundException;
import com.lti.flipshop.flipkart.exeception.ShipperNotFoundException;
import com.lti.flipshop.flipkart.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lti.flipshop.flipkart.entity.Order;
import com.lti.flipshop.flipkart.service.OrderService;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/api/v1/order")
    public ResponseEntity<String> newOrder(@RequestBody @Valid  OrderVo order) throws ParseException {
        orderService.newOrder(order);
        return new ResponseEntity<>("Order Successfully Placed", HttpStatus.OK);
    }

    @GetMapping("/api/v1/order")
    public ResponseEntity<List<Order>> getOrders(){
        return orderService.getOrders();
    }


    @GetMapping("api/vi/order/{orderID}")
    public ResponseEntity<Order> findOrder(@PathVariable Integer orderID) {
        return orderService.findOrder(orderID);
    }
}
