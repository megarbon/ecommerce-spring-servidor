package es.ecommerce.sneakerFreaks.service;

import es.ecommerce.sneakerFreaks.dao.OrderDAO;
import es.ecommerce.sneakerFreaks.dao.OrderDetailDAO;
import es.ecommerce.sneakerFreaks.model.Order;
import es.ecommerce.sneakerFreaks.model.OrderDetail;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    // Inyectamos el DAO de Order y el DAO de OrderDetail ya que necesitaremos
    // OrderDetail para poder añadir varios detalles a un pedido
    private final OrderDAO orderDao;
    private final OrderDetailDAO orderDetailDao;

    public OrderService(OrderDAO orderDao, OrderDetailDAO orderDetailDao) {
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
    }

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrderById(Long id) {
        return orderDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found with id: " + id));
    }

    public Order createOrder(Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(Long id) {
        if (orderDao.existsById(id)) {
            orderDao.deleteById(id);
        } else {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
    }

    public Order addDetailsToOrder(Long orderId, List<OrderDetail> orderDetails) {
        Order order = orderDao.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found with id: " + orderId));

        // Set the order reference for each order detail
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrder(order);
        }

        // Save order details using OrderDetailDAO
        orderDetailDao.saveAll(orderDetails);

        // Add order details to the order
        order.getOrderDetails().addAll(orderDetails);

        // Update the order in the database
        return orderDao.save(order);
    }

}
