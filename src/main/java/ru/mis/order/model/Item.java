package ru.mis.order.model;

public class Item {

    private Integer id;
    private Integer orderId;
    private String itemName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{ " +
                "id = " + id +
                ", item_name = '" + itemName + '\'' +
                '}';
    }
}
