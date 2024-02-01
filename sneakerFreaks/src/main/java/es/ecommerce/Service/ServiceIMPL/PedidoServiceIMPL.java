package es.ecommerce.Service.ServiceIMPL;

import es.ecommerce.Entity.Cliente;
import es.ecommerce.Entity.Pedido;
import es.ecommerce.Entity.Producto;
import es.ecommerce.Repository.PedidoRepository;
import es.ecommerce.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//Esta implementación no está completa o falta que se cuadre respecto a la entidad
@Service
public class PedidoServiceIMPL implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public Pedido insertarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido editarPedido(Long idPedido, Cliente cliente, List<Producto> productos, Integer cantidad,
            LocalDate fechaPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido != null) {
            pedido.setCliente(cliente);
            pedido.setlistaProductos(productos);
            pedido.setCantidad(cantidad);
            pedido.setFechaPedido(fechaPedido);
            return pedidoRepository.save(pedido);
        }
        return null;
    }
}
