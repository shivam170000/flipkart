package com.lti.flipshop.flipkart.controller;


import com.lti.flipshop.flipkart.entity.Shipper;
import com.lti.flipshop.flipkart.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class ShipperController {

    @Autowired
    ShipperService shipperService;



    @GetMapping("/api/v1/shipper")
    public ResponseEntity<List<Shipper>> getShippers(){
        return shipperService.getShippers();
    }

    @GetMapping("api/v1/shipper/{id}")
    public ResponseEntity<Shipper> getShipperById(@PathVariable Integer id){
        return shipperService.getShipperById(id);
    }

}
