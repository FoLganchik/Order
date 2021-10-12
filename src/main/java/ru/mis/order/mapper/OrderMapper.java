package ru.mis.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.mis.order.model.Item;
import ru.mis.order.model.Order;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OrderMapper {

	void createOrder(@Param("ord") Order order);

    void createItem(@Param("oi") Item item);

    List<Order> readAll();

    Order read(Integer id);

    Integer update(@Param("ord") Order order);

    Integer delete(Integer id);
}
