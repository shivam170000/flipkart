package com.lti.flipshop.flipkart.service;


import com.lti.flipshop.flipkart.exeception.CustomerNotFoundException;
import com.lti.flipshop.flipkart.exeception.OrderNotFoundException;
import com.lti.flipshop.flipkart.exeception.ShipperNotFoundException;
import com.lti.flipshop.flipkart.respository.CustomerRepository;
import com.lti.flipshop.flipkart.respository.OrderRepository;
import com.lti.flipshop.flipkart.respository.ShipperRepository;
import com.lti.flipshop.flipkart.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lti.flipshop.flipkart.entity.*;
import com.lti.flipshop.flipkart.vo.OrderVo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShipperRepository shipperRepository;

    public void newOrder(OrderVo orderVo) throws ParseException {
        if(customerRepository.findById(orderVo.getCustomerID()).isEmpty()){
            throw new CustomerNotFoundException(orderVo.getCustomerID());
        }
        if(shipperRepository.findById(orderVo.getShipperID()).isEmpty())
            throw new ShipperNotFoundException((orderVo.getShipperID()));

        Order order1 = preparingOrder(orderVo);
        orderRepository.save(order1);
    }

    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Order> findOrder(Integer id) {

        if(orderRepository.findById(id).isPresent()){
            return new ResponseEntity<>(orderRepository.findById(id).get(),HttpStatus.OK);
        }
        else{
            throw new OrderNotFoundException(id);
        }
    }
    public static Order preparingOrder(OrderVo orderVo) throws ParseException {
        Order ord = new Order();
        Customer cust = new Customer();
        Shipper ship = new Shipper();
      //  OrderDetailVo orderDetailVo = new OrderDetailVo();
        ord.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate()));
        cust.setCustomerID(orderVo.getCustomerID());
        ord.setCustomer(cust);
        ship.setShipperID(orderVo.getShipperID());
        ord.setShipper(ship);
        List<OrderDetails> orderD = new ArrayList<>();
        for(OrderDetailVo orderDetailVo1 : orderVo.getOrderDetails()) {
                orderD.add(OrderDetailsService.orderDetailVoToOrderDetail(orderDetailVo1));
        }
        ord.setOrderDetails(orderD);
        return ord;
    }

}
