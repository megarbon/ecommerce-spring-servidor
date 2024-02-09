package es.ecommerce.sneakerFreaks.service;

import es.ecommerce.sneakerFreaks.model.OrderProduct;
import es.ecommerce.sneakerFreaks.dao.OrderProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {

    private final OrderProductDAO orderProductDAO;

    public OrderProductService(OrderProductDAO orderProductDAO) {
        this.orderProductDAO = orderProductDAO;
    }

    //Este metodo no se si obtiene todos los productos de un pedido o todos los productos en general de todos los pedidos.
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductDAO.findAll();
    }

    public Optional<OrderProduct> getOrderProductById(Long id) {
        return orderProductDAO.findById(id);
    }

    public OrderProduct createOrderProduct(OrderProduct orderProduct) {
        return orderProductDAO.save(orderProduct);
    }

    public void deleteOrderProduct(Long id) {
        orderProductDAO.deleteById(id);
    }
}
