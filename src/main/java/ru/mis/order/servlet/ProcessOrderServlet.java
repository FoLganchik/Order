package ru.mis.order.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.mis.order.model.Item;
import ru.mis.order.model.Order;
import ru.mis.order.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;

@WebServlet(value = "/orderServlet")
public class ProcessOrderServlet extends HttpServlet {

    private Node itemsNode;
    private Order order = new Order();
    private final ArrayList<Item> items = new ArrayList<>();
    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public ProcessOrderServlet(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        switch (request.getMethod()) {
            case "GET": {
                doGet(request, response);
                break;
            }
            case "POST": {
                doPost(request, response);
                break;
            }
            case "PUT": {
                doPut(request, response);
                break;
            }
            case "DELETE": {
                doDelete(request, response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter writer = response.getWriter();
            NodeList rootChild = getChildNodes(request);

            for (int i = 0; i < rootChild.getLength(); i++) {
                if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if ((rootChild.item(i).getNodeName()).equals("id")) {
                    order.setId(Integer.valueOf(rootChild.item(i).getTextContent()));
                }
                order = orderServiceImpl.read(order.getId());
                writer.println();
                writer.println(order.getOrderStatusId());
                writer.println(order.getCustomerName());
                writer.println(order.getCustomerPhone());
                writer.println(order.getCustomerComment());
                for (Item item : order.getItems()) {
                    writer.println(item.getItemName());
                }
            }
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String data = requestBuffer(request);
            Node root = buildDocument(data).getDocumentElement();
            NodeList rootChild = root.getChildNodes();
            for (int i = 0; i < rootChild.getLength(); i++) {
                if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (rootChild.item(i).getNodeName()) {
                    case "orderStatusId": {
                        order.setOrderStatusId(Integer.valueOf(rootChild.item(i).getTextContent()));
                        break;
                    }
                    case "customerName": {
                        order.setCustomerName(rootChild.item(i).getTextContent());
                        break;
                    }
                    case "customerPhone": {
                        order.setCustomerPhone(rootChild.item(i).getTextContent());
                        break;
                    }
                    case "customerComment": {
                        order.setCustomerComment(rootChild.item(i).getTextContent());
                        break;
                    }
                    case "items": {
                        itemsNode = rootChild.item(i);
                        break;
                    }
                }
            }

            NodeList itemsList = itemsNode.getChildNodes();
            for (int i = 0; i < itemsList.getLength(); i++) {
                if (itemsList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                Item item = new Item();
                item.setItemName(itemsList.item(i).getTextContent());
                items.add(item);
            }
            order.setItems(items);

        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        orderServiceImpl.createOrder(order);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String data = requestBuffer(request);
            Node root = buildDocument(data).getDocumentElement();
            NodeList rootChild = root.getChildNodes();
            for (int i = 0; i < rootChild.getLength(); i++) {
                if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (rootChild.item(i).getNodeName()) {
                    case "id": {
                        order.setId(Integer.valueOf(rootChild.item(i).getTextContent()));
                        break;
                    }
                    case "orderStatusId": {
                        order.setOrderStatusId(Integer.valueOf(rootChild.item(i).getTextContent()));
                        break;
                    }
                    case "customerName": {
                        order.setCustomerName(rootChild.item(i).getTextContent());
                        break;
                    }
                    case "customerPhone": {
                        order.setCustomerPhone(rootChild.item(i).getTextContent());
                        break;
                    }
                    case "customerComment": {
                        order.setCustomerComment(rootChild.item(i).getTextContent());
                        break;
                    }
                    case "items": {
                        itemsNode = rootChild.item(i);
                        break;
                    }
                }
            }

            NodeList itemsList = itemsNode.getChildNodes();
            for (int i = 0; i < itemsList.getLength(); i++) {
                if (itemsList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (!itemsList.item(i).getNodeName().equals("item")) {
                    continue;
                }
                Item item = new Item();
                NodeList itemElements = itemsList.item(i).getChildNodes();
                for (int j = 0; j < itemElements.getLength(); j++) {
                    if (itemElements.item(j).getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }

                    switch (itemElements.item(j).getNodeName()) {
                        case "id": {
                            item.setId(Integer.valueOf(itemElements.item(j).getTextContent()));
                            break;
                        }
                        case "orderId": {
                            item.setOrderId(Integer.valueOf(itemElements.item(j).getTextContent()));
                            break;
                        }
                        case "itemName": {
                            item.setItemName(itemElements.item(j).getTextContent());
                            break;
                        }
                    }
                }
                items.add(item);
            }
            order.setItems(items);

        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        orderServiceImpl.update(order);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NodeList rootChild = getChildNodes(request);

            for (int i = 0; i < rootChild.getLength(); i++) {
                if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (!(rootChild.item(i).getNodeName()).equals("id")) {
                    continue;
                }
                orderServiceImpl.delete(Integer.parseInt(rootChild.item(i).getTextContent()));
            }
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private NodeList getChildNodes(HttpServletRequest request) throws IOException, ParserConfigurationException, SAXException {
        String data = requestBuffer(request);
        Node root = buildDocument(data).getDocumentElement();
        return root.getChildNodes();
    }

    private Document buildDocument(String data) throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance().
                newDocumentBuilder().parse(new InputSource(new StringReader(data)));
    }

    private String requestBuffer(HttpServletRequest request) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }
        return buffer.toString();
    }
}