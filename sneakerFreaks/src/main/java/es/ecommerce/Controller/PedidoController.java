package es.ecommerce.Controller;

import es.ecommerce.Entity.Cliente;
import es.ecommerce.Entity.Pedido;
import es.ecommerce.Entity.Producto;
import es.ecommerce.Service.ServiceIMPL.PedidoServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceIMPL pedidoService;

    @GetMapping("/consultar")
    @RequestMapping(value = "ConsultarDeportes", method = RequestMethod.GET)
    public ResponseEntity<List<Pedido>> consultarPedidos() {
        List<Pedido> listaPedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(listaPedidos);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Pedido> insertarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoInsertado = pedidoService.insertarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoInsertado);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Pedido> modificarPedido(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        try {
            Cliente cliente = (Cliente) body.get("cliente");
            List<Producto> productos = (List<Producto>) body.get("productos");
            Integer cantidad = (Integer) body.get("cantidad");
            LocalDate fechaPedido = LocalDate.parse((String) body.get("fechaPedido"));

            Pedido pedidoModificado = pedidoService.editarPedido(id, cliente, productos, cantidad, fechaPedido);

            if (pedidoModificado != null) {
                return ResponseEntity.ok(pedidoModificado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedidoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/hola")
    public ResponseEntity<String> holaMundo() {
        return ResponseEntity.ok("¡Hola Mundo!");
    }
}
