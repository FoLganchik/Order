package ru.mis.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mis.order.dao.OrderRepositoryImpl;
import ru.mis.order.model.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepositoryImpl orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.readAll();
    }

    @Override
    public Order read(int id) {
        return orderRepository.read(id);
    }

    @Override
    public Integer update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public Integer delete(int id) {
        return orderRepository.delete(id);
    }
}
