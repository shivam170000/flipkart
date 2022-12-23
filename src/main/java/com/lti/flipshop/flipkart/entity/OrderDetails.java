package com.lti.flipshop.flipkart.entity;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails_10708661")
public class OrderDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;
    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}