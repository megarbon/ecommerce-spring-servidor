package es.ecommerce.service;

import java.time.LocalDate;
import java.util.List;

import es.ecommerce.entity.HistorialPedidos;

public interface HistorialPedidosService {

    List<HistorialPedidos> listarHistoriales();

    HistorialPedidos insertarHistorial(HistorialPedidos historial);

    HistorialPedidos buscarHistorialPorId(Long id);

    HistorialPedidos editarHistorial(Long id, Long idPedido, Long idCliente, LocalDate fechaPedido);

    void eliminarHistorialPorId(Long id);
}
