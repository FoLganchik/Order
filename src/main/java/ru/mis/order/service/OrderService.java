package ru.mis.order.service;

import ru.mis.order.model.Order;

import java.util.List;

public interface OrderService {

	void create(Order order);

    List<Order> readAll();

    Order read(int id);

    Integer update(Order order);

    Integer delete(int id);
}
