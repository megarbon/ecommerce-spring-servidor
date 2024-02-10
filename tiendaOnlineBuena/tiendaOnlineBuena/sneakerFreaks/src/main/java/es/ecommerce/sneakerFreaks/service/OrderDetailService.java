package es.ecommerce.sneakerFreaks.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import es.ecommerce.sneakerFreaks.model.OrderDetail;
import jakarta.persistence.EntityNotFoundException;
import es.ecommerce.sneakerFreaks.dao.OrderDetailDAO;

@Service
public class OrderDetailService {
    private final OrderDetailDAO OrderDetailDAO;

    public OrderDetailService(OrderDetailDAO OrderDetailDAO) {
        this.OrderDetailDAO = OrderDetailDAO;
    }

    public List<OrderDetail> getAllOrderDetails() {
        return OrderDetailDAO.findAll();
    }

    public OrderDetail getOrderDetailById(Long id) {
        return OrderDetailDAO.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order detail not found with id: " + id));
    }

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return OrderDetailDAO.save(orderDetail);
    }

    public void deleteOrderDetail(Long id) {
        if (OrderDetailDAO.existsById(id)) {
            OrderDetailDAO.deleteById(id);
        } else {
            throw new EntityNotFoundException("Order detail not found with id: " + id);
        }
    }

    
}
