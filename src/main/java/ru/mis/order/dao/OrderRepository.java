package ru.mis.order.dao;

import ru.mis.order.model.Order;

import java.util.List;

public interface OrderRepository {

    Integer create(Order order);

    List<Order> readAll();

    Order read(int id);

    Integer update(Order order);

    Integer delete(int id);
}
