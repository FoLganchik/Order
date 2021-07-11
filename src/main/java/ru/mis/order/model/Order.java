package ru.mis.order.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "order_status_id")
    private Integer order_status_id;
    @Column(name = "customer_name")
    private String customer_name;
    @Column(name = "customer_phone")
    private String customer_phone;
    @Column(name = "customer_comment")
    private String customer_comment;
    @OneToMany
    private Set<Item> items;

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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
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
