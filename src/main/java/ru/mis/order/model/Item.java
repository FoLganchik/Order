package ru.mis.order.model;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "item_name")
    private String item_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return item_name;
    }

    public void setName(String item_name) {
        this.item_name = item_name;
    }
}
