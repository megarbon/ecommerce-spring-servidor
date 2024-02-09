package es.ecommerce.sneakerFreaks.service;

import es.ecommerce.sneakerFreaks.dao.OrderDAO;
import es.ecommerce.sneakerFreaks.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderDAO orderDao;

    @Autowired
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
}
