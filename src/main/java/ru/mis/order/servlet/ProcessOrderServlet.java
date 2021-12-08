package ru.mis.order.servlet;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.mis.order.mapper.OrderMapper;
import ru.mis.order.model.Item;
import ru.mis.order.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

@WebServlet(value = "/orderServlet")
public class ProcessOrderServlet extends HttpServlet {

    private Order order = new Order();
    OrderMapper orderMapper;
    private NodeList itemsNode;
    private Item item = new Item();
    private ArrayList<Item> items = new ArrayList<>();

    public void init() throws ServletException {
        String message = "Welcome";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }
            String data = buffer.toString();

            Document parsed = DocumentBuilderFactory.newInstance().
                    newDocumentBuilder().parse(new InputSource(new StringReader(data)));
            Node root = parsed.getDocumentElement();
            NodeList rootChild = root.getChildNodes();
            for (int i = 0; i < rootChild.getLength(); i++) {
                if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (rootChild.item(i).getNodeName()) {
                    case "orderStatusId": {
                        order.setOrderStatusId(Integer.valueOf(rootChild.item(i).getTextContent()));
                    }
                    case "customerName": {
                        order.setCustomerName(rootChild.item(i).getTextContent());
                    }
                    case "customerPhone": {
                        order.setCustomerPhone(rootChild.item(i).getTextContent());
                    }
                    case "customerComment": {
                        order.setCustomerComment(rootChild.item(i).getTextContent());
                    }
                    case "items": {
                        itemsNode = rootChild.item(i).getChildNodes();
                    }
                }
            }

            NodeList itemsList = itemsNode;
            for (int i = 0; i < itemsList.getLength(); i++) {
                if (itemsList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                item.setItemName(itemsList.item(i).getTextContent());
                items.add(item);
            }
            order.setItems(items);

        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

//        System.out.println(order.getOrderStatusId() + " " + order.getCustomerName() + " " + order.getCustomerPhone()
//                + " " + order.getCustomerComment() + " " + order.getItems());

        orderMapper.createOrder(order);
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}