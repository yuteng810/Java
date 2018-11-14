package edu.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;
    private String orderNo;
    private Date date;
    private Double total;
    private Customer customer;

    public Order(String orderNo, Date date, Double total) {
        this.orderNo = orderNo;
        this.date = date;
        this.total = total;
    }

    public Order(String orderNo, Date date, Double total, Customer customer) {
        this(orderNo, date, total);
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
