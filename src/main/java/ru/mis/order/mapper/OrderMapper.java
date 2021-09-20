package ru.mis.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.mis.order.model.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    Integer create(Order order);

    List<Order> readAll();

    Order read(Integer id);

    Integer update(@Param("ord") Order order);

    Integer delete(Integer id);
}
