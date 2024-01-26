package es.ecommerce.Service;

import es.ecommerce.Entity.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService {

    List<Pedido> listarPedidoss();

    Pedido insertarPedido(Pedido pedido);

    Pedido buscarPedidoPorId(Long id);

    // Aquí tengo un problema ya que idProducto y cantidadProducto son de la tabla
    // producto y son listas (no se como implementar eso por ahora).
    Pedido editarPedido(Long idPedido, Long idCliente, Long idProducto, Integer cantidadProducto,
            LocalDate fechaPedido);

    void eliminarPedidoPorId(Long id);
}
