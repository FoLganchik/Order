package ru.mis.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.mis.order.model.Item;
import ru.mis.order.model.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

	void createOrder(@Param("ord") Order order);

    void createItem(@Param("oi") Item item);

    List<Order> readAll();

    Order read(Integer id);

    void updateOrder(@Param("ord") Order order);

    void updateItem(@Param("oi") Item item);

    void delete(Integer id);
}
