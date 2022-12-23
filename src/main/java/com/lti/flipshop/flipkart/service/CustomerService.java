package com.lti.flipshop.flipkart.service;


import com.lti.flipshop.flipkart.entity.Customer;
import com.lti.flipshop.flipkart.exeception.CustomerAlreadyExistException;
import com.lti.flipshop.flipkart.exeception.CustomerNotFoundException;
import com.lti.flipshop.flipkart.respository.CustomerRepository;
import com.lti.flipshop.flipkart.validation.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lti.flipshop.flipkart.vo.CustomerVo;
import java.util.List;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> getCustomers()  { //generic {java 5}
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }


    //insertion
    public void addCustomer(ValidList<CustomerVo> customers) {
        for (CustomerVo customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isPresent()) {
                throw new CustomerAlreadyExistException(customer.getCustomerID());
            }
            System.out.println("Getting vo class object");
            customerRepository.save(getEntityCustomer(customer));
        }
    }

    public void updateCustomer(List<CustomerVo> customers)  {
        for (CustomerVo customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isEmpty()) {
                throw new CustomerNotFoundException(customer.getCustomerID());
            }
            customerRepository.save(getEntityCustomer(customer));
        }
    }



    public static Customer getEntityCustomer(CustomerVo customerVo){

        System.out.println("Inside entity conversation method");

        Customer cust = new Customer();
        cust.setCustomerID(customerVo.getCustomerID());
        cust.setCustomerName(customerVo.getCustomerName());
        cust.setAddress(customerVo.getAddress());
        cust.setCity(customerVo.getCity());
        cust.setCountry(customerVo.getCountry());
        cust.setPostalCode(customerVo.getPostalCode());
        return cust;
    }
}