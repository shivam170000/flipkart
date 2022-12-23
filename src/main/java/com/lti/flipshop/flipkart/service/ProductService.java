package com.lti.flipshop.flipkart.service;


import com.lti.flipshop.flipkart.entity.Product;
import com.lti.flipshop.flipkart.exeception.ProductAlreadyExistException;
import com.lti.flipshop.flipkart.exeception.ProductNotFoundException;
import com.lti.flipshop.flipkart.respository.ProductRepository;
import com.lti.flipshop.flipkart.respository.SupplierRepository;
import com.lti.flipshop.flipkart.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lti.flipshop.flipkart.entity.Supplier;


import java.util.List;


@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;


    @Autowired
    SupplierRepository supplierRepository;


    //product insertion
    public void addProduct(List<ProductVo> products) throws ProductAlreadyExistException{
        for(ProductVo prod : products){
            if(productRepository.findById(prod.getProductID()).isPresent()){
                throw new ProductAlreadyExistException(prod.getProductID());
            }
            productRepository.save(getProductEntity(prod));
        }
    }


    //fetching
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }



    //update
    public void updateProduct(List<ProductVo> products) throws ProductNotFoundException{
        for(ProductVo prod : products) {
            if (productRepository.findById(prod.getProductID()).isEmpty()) {
                throw new ProductNotFoundException(prod.getProductID());
            }
            productRepository.save(getProductEntity(prod));
        }
    }


    //finding product by product id
    public ResponseEntity<Product> getProductByPid(Integer pid)  {

        if(productRepository.findById(pid).isPresent()){
            return new ResponseEntity<>(productRepository.findById(pid).get(),HttpStatus.OK);
        }
        else{
            throw new ProductNotFoundException(pid);
        }
    }


    public Product getProductEntity(ProductVo productVo){
        Product product = new Product();
        product.setProductID(productVo.getProductID());
        product.setProductName(productVo.getProductName());
        product.setSupplier(supplierRepository.findById(productVo.getSupplierID()).get());
        Supplier sup = supplierRepository.findById(productVo.getSupplierID()).get();
        product.setUnit(productVo.getUnit());
        product.setPrice(productVo.getPrice());
       //System.out.println("Here" + productVo.getSupplierID());
      //  System.out.println("Here also " + sup);
        return product;
    }



}
