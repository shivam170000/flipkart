package com.lti.flipshop.flipkart.service;


import com.lti.flipshop.flipkart.entity.OrderDetails;
import com.lti.flipshop.flipkart.entity.Product;
import com.lti.flipshop.flipkart.vo.OrderDetailVo;
import org.springframework.stereotype.Service;


@Service
public class OrderDetailsService {

    public static OrderDetails orderDetailVoToOrderDetail(OrderDetailVo orderDetailVo) {
        OrderDetails orderD = new OrderDetails();
        Product product = new Product();
        product.setProductID(orderDetailVo.getProductID());
        orderD.setProduct(product);
        orderD.setQuantity(orderDetailVo.getQuantity());
        return orderD;
    }
}
