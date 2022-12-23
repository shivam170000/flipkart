package com.lti.flipshop.flipkart.controller;

import java.util.*;
import com.lti.flipshop.flipkart.entity.Product;
import com.lti.flipshop.flipkart.exeception.ProductNotFoundException;
import com.lti.flipshop.flipkart.service.ProductService;
import com.lti.flipshop.flipkart.validation.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.lti.flipshop.flipkart.exeception.ProductAlreadyExistException;
import com.lti.flipshop.flipkart.vo.ProductVo;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/api/v1/products")
    public ResponseEntity<String> addProduct(@RequestBody @Valid ValidList<ProductVo> product) {
        productService.addProduct(product);
        return new ResponseEntity<>("Product added succesfully", HttpStatus.OK);
    }

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<Product>> getProducts(){
       return productService.getProducts();
    }

    @PutMapping("api/v1/products")
    public ResponseEntity<String> updateProduct(@RequestBody @Valid ValidList<ProductVo> product) {
        productService.updateProduct(product);
        return new ResponseEntity<>("Product Details Updated", HttpStatus.OK);
    }


    @GetMapping("api/v1/products/{pid}")
    public ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) {
        return productService.getProductByPid(pid);
    }


}
