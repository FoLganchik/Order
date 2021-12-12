package ru.mis.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mis.order.dao.OrderRepositoryImpl;
import ru.mis.order.model.Item;
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
    public void createOrder(Order order) {
        orderRepository.createOrder(order);
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
    public void update(Order order) {
        orderRepository.update(order);
    }

    @Override
    public void delete(int id) {
        orderRepository.delete(id);
    }
}
