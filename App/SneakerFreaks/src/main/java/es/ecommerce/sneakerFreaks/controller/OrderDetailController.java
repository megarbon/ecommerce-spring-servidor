package es.ecommerce.sneakerFreaks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ecommerce.sneakerFreaks.model.OrderDetail;
import es.ecommerce.sneakerFreaks.service.OrderDetailService;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/add")
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail createdOrderDetail = orderDetailService.createOrderDetail(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDetail);
    }

    // Otros métodos para leer, actualizar y eliminar detalles de pedidos
}
