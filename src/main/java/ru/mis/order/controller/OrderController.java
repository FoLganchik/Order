package ru.mis.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mis.order.model.Order;
import ru.mis.order.service.OrderServiceImpl;
import java.util.List;

//
//test commit
//

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order) {
    	orderServiceImpl.createOrder(order);
		return order;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> readAll() {
        return orderServiceImpl.readAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order read(@PathVariable("id") Integer id) {
        return orderServiceImpl.read(id);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Integer id, @ModelAttribute Order order) {
        orderServiceImpl.update(order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        orderServiceImpl.delete(id);
    }
}
