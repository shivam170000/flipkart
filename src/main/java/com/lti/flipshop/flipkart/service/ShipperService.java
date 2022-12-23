package com.lti.flipshop.flipkart.service;

import com.lti.flipshop.flipkart.entity.Shipper;
import com.lti.flipshop.flipkart.respository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;

    //fetching shipper details
    public ResponseEntity getShippers(){
        return new ResponseEntity(shipperRepository.findAll(), HttpStatus.OK);
    }


    //fetching shipper by shipperid
     public ResponseEntity getShipperById(Integer sid){
       // Optional<Shipper> shipper = shipperRepository.findById(sid);
       // return shipper;
       return new ResponseEntity<>(shipperRepository.findById(sid) , HttpStatus.OK);
    }

}
