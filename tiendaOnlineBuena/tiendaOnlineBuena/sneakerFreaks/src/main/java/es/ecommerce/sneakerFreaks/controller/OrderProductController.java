package es.ecommerce.sneakerFreaks.controller;

import es.ecommerce.sneakerFreaks.model.OrderProduct;
import es.ecommerce.sneakerFreaks.service.OrderProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderProducts")
public class OrderProductController {

    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping("/getAll") // Obtener todos los productos del pedido
    public ResponseEntity<List<OrderProduct>> getAllOrderProducts() {
        try {
            List<OrderProduct> orderProducts = orderProductService.getAllOrderProducts();
            return new ResponseEntity<>(orderProducts, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}") // Obtener un producto del pedido por ID
    public ResponseEntity<OrderProduct> getOrderProductById(@PathVariable("id") Long id) {
        OrderProduct orderProduct = orderProductService.getOrderProductById(id).orElse(null);
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderProduct, HttpStatus.OK);
    }

    @PutMapping("/update/{id}") // Actualizar un producto del pedido por ID
    public ResponseEntity<OrderProduct> updateOrderProduct(@PathVariable("id") Long id,
            @RequestBody Map<String, String> body) {
        try {
            // Obtener los campos del cuerpo de la solicitud
            // Ajusta los campos de acuerdo a tu modelo de datos
            // Aquí se asume que se pueden actualizar los campos cantidad_producto y/o
            // id_producto
            int quantity = Integer.parseInt(body.get("cantidad_producto"));
            Long productId = Long.parseLong(body.get("id_producto"));

            // Obtener el producto del pedido actual
            OrderProduct currentOrderProduct = orderProductService.getOrderProductById(id).orElse(null);

            // Verificar si el producto del pedido existe
            if (currentOrderProduct == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Actualizar los campos del producto del pedido
            currentOrderProduct.setQuantity(quantity);
            // Asignar el nuevo ID de producto si se proporcionó en la solicitud
            if (productId != null) {
                currentOrderProduct.setOrderProductId(productId);
            }

            // Guardar los cambios
            OrderProduct updatedOrderProduct = orderProductService.createOrderProduct(currentOrderProduct);

            // Verificar si se actualizó correctamente
            if (updatedOrderProduct != null) {
                return ResponseEntity.ok(updatedOrderProduct);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (NumberFormatException e) {
            // Manejar error de conversión de tipos
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/create") // Crear un nuevo producto del pedido
    public ResponseEntity<?> createOrderProduct(@RequestBody OrderProduct orderProduct) {
        try {
            // Insertar el producto del pedido en la base de datos
            OrderProduct createdOrderProduct = orderProductService.createOrderProduct(orderProduct);

            // Devolver una respuesta con el producto del pedido insertado y el código de
            // estado 201 (CREATED)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderProduct);
        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante el proceso de inserción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @DeleteMapping("/delete/{id}") // Eliminar un producto del pedido por ID
    public ResponseEntity<Void> deleteOrderProduct(@PathVariable("id") Long id) {
        try {
            orderProductService.deleteOrderProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
