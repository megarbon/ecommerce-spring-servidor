package es.ecommerce.service;

import java.time.LocalDate;
import java.util.List;

import es.ecommerce.entity.Cliente;
import es.ecommerce.entity.Pedido;
import es.ecommerce.entity.Producto;

public interface PedidoService {

    List<Pedido> listarPedidos();

    Pedido insertarPedido(Pedido pedido);

    Pedido buscarPedidoPorId(Long id);

    // Aquí tengo un problema ya que idProducto y cantidadProducto son de la tabla
    // producto y son listas (no se como implementar eso por ahora).
    Pedido editarPedido(Long idPedido, Cliente cliente, List<Producto> productos, Integer cantidadProducto,
            LocalDate fechaPedido);

    void eliminarPedidoPorId(Long id);
}
