package es.ecommerce.sneakerFreaks.service;

import es.ecommerce.sneakerFreaks.dao.OrderDAO;
import es.ecommerce.sneakerFreaks.model.Order;
import es.ecommerce.sneakerFreaks.model.OrderProduct;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderDAO orderDao;

    public OrderService(OrderDAO orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrderById(Long id) {
        return orderDao.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(Long id) {
        orderDao.deleteById(id);
    }

    public Order addItemsToOrder(Long orderId, List<OrderProduct> orderProducts) {
        // Retrieve the existing order from the database
        Order existingOrder = orderDao.findById(orderId).orElse(null);

        // Check if the order exists
        if (existingOrder == null) {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }

        // Add the new order products to the existing order
        List<OrderProduct> existingOrderProducts = existingOrder.getOrderProducts();
        existingOrderProducts.addAll(orderProducts);
        existingOrder.setOrderProducts(existingOrderProducts);

        // Save the updated order back to the database
        return orderDao.save(existingOrder);
    }
}
