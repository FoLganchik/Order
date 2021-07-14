package ru.mis.order.model;

public class Item {

    private Integer id;
    private Integer order_id;
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

    @Override
    public String toString() {
        return "Item{ " +
                "id = " + id +
                ", item_name = '" + item_name + '\'' +
                '}';
    }
}
