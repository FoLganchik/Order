package ru.mis.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mis.order.mapper.OrderMapper;
import ru.mis.order.model.Item;
import ru.mis.order.model.Order;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderRepositoryImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void createOrder(Order order) {
        orderMapper.createOrder(order);
        for (Item items : order.getItems()) {
            items.setOrderId(order.getId());
            orderMapper.createItem(items);
        }
    }

    @Override
    public List<Order> readAll() {
        return orderMapper.readAll();
    }

    @Override
    public Order read(int id) {
        return orderMapper.read(id);
    }

    @Transactional
    public void update(Order order) {
        orderMapper.updateOrder(order);
        for (Item items : order.getItems()) {
            orderMapper.updateItem(items);
        }
    }

    @Override
    public void delete(int id) {
        orderMapper.delete(id);
    }
}
