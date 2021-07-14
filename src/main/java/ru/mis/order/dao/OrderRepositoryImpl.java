package ru.mis.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mis.order.mapper.OrderMapper;
import ru.mis.order.model.Order;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderRepositoryImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Integer create(Order order) {
        return orderMapper.create(order);
    }

    @Override
    public List<Order> readAll() {
        return orderMapper.readAll();
    }

    @Override
    public Order read(int id) {
        return orderMapper.read(id);
    }

    @Override
    public Integer update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public Integer delete(int id) {
        return orderMapper.delete(id);
    }
}
