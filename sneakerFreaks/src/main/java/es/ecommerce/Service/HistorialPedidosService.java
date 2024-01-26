package es.ecommerce.Service;

import es.ecommerce.Entity.HistorialPedidos;

import java.util.List;

public interface HistorialService {

    List<Historial> listarHistoriales();

    Historial insertarHistorial(Historial historial);

    Historial buscarHistorialPorId(Long id);

    Historial editarHistorial(Long id, Long idPedido, Long idCliente, LocalDate fechaPedido);

    void eliminarHistorialPorId(Long id);
}
