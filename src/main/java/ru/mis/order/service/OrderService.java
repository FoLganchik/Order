package ru.mis.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mis.order.mapper.IOrderMapper;
import ru.mis.order.model.Order;

import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {

    private final IOrderMapper iOrderMapper;

    @Autowired
    public OrderService(IOrderMapper iOrderMapper) {
        this.iOrderMapper = iOrderMapper;
    }

    @Override
    public Integer create(Order order) {
        return iOrderMapper.create(order);
    }

    @Override
    public List<Order> readAll() {
        return iOrderMapper.readAll();
    }

    @Override
    public Order read(int id) {
        return iOrderMapper.read(id);
    }

    @Override
    public Integer update(Order order) {
        return iOrderMapper.update(order);
    }

    @Override
    public Integer delete(int id) {
        return iOrderMapper.delete(id);
    }
}
