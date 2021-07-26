package ru.mis.order.model;

import java.util.ArrayList;

public class Order {

    private Integer id;
    private Integer orderStatusId;
    private String customerName;
    private String customerPhone;
    private String customerComment;
    private ArrayList<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order {" +
                "id = " + id +
                ", order_status_id = " + orderStatusId +
                ", customer_name = '" + customerName + '\'' +
                ", customer_phone = '" + customerPhone + '\'' +
                ", customer_comment = '" + customerComment + '\'' +
                '}';
    }
}
