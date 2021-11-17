package ru.mis.order.servlet;

import ru.mis.order.mapper.OrderMapper;
import ru.mis.order.model.Order;
import ru.mis.order.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/orderServlet")
public class ProcessOrderServlet extends HttpServlet {

    private String message;
    Order order = new Order();
    OrderMapper orderMapper;

    public void init() throws ServletException {
        message = "Welcome";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        order.setOrderStatusId((Integer) session.getAttribute("orderStatusId"));
        order.setCustomerName((String) session.getAttribute("customerName"));
        order.setCustomerPhone((String) session.getAttribute("customerPhone"));
        order.setCustomerComment((String) session.getAttribute("customerComment"));

        orderMapper.createOrder(order);
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }

}
