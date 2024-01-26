package es.ecommerce.Service;

import es.ecommerce.Entity.HistorialPedidos;

import java.time.LocalDate;
import java.util.List;

public interface HistorialPedidosService {

    List<HistorialPedidos> listarHistoriales();

    HistorialPedidos insertarHistorial(HistorialPedidos historial);

    HistorialPedidos buscarHistorialPorId(Long id);

    HistorialPedidos editarHistorial(Long id, Long idPedido, Long idCliente, LocalDate fechaPedido);

    void eliminarHistorialPorId(Long id);
}
