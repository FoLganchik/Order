package ru.mis.order.service;

import ru.mis.order.model.Order;

import java.util.List;

public interface OrderService {

	void createOrder(Order order);

    List<Order> readAll();

    Order read(int id);

    void update(Order order);

    void delete(int id);
}
