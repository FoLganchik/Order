package ru.mis.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mis.order.model.Order;
import ru.mis.order.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute Order order) {
        Integer create = orderService.create(order);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Order> readAllOrder() {
        return orderService.readAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Order readOrder(@PathVariable("id") Integer id) {
        return orderService.read(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateOrder(@PathVariable("id") Integer id, @ModelAttribute Order order) {
        Integer updateOrder = orderService.update(order);
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable("id") Integer id) {
        Integer deleteOrder = orderService.delete(id);
        return "success";
    }
}
