package ru.mis.order.model;

import java.util.ArrayList;

public class Order {

    private Integer id;
    private Integer order_status_id;
    private String customer_name;
    private String customer_phone;
    private String customer_comment;
    private ArrayList<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_status_id() {
        return order_status_id;
    }

    public void setOrder_status_id(Integer order_status_id) {
        this.order_status_id = order_status_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_comment() {
        return customer_comment;
    }

    public void setCustomer_comment(String customer_comment) {
        this.customer_comment = customer_comment;
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
                ", order_status_id = " + order_status_id +
                ", customer_name = '" + customer_name + '\'' +
                ", customer_phone = '" + customer_phone + '\'' +
                ", customer_comment = '" + customer_comment + '\'' +
                '}';
    }
}
