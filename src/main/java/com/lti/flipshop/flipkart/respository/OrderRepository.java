package com.lti.flipshop.flipkart.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lti.flipshop.flipkart.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order , Integer> {
}
