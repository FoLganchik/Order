package ru.mis.order.mapper;

import org.springframework.stereotype.Component;
import ru.mis.order.model.Order;

import java.util.List;

@Component
public interface IOrderMapper {

    Integer create(Order order);

    List<Order> readAll();

    Order read(int id);

    Integer update(Order order);

    Integer delete(int id);
}
