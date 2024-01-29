package es.ecommerce.Service.ServiceIMPL;

import es.ecommerce.Entity.HistorialPedidos;
import es.ecommerce.Repository.HistorialPedidosRepository;
import es.ecommerce.Service.HistorialPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//implementación sin completar aun faltan algunos metodos por retocar
@Service
public class HistorialPedidosServiceIMPL implements HistorialPedidosService {

    @Autowired
    private HistorialPedidosRepository historialRepository;

    @Override
    public List<HistorialPedidos> listarHistoriales() {
        return (List<HistorialPedidos>) historialRepository.findAll();
    }

    @Override
    public HistorialPedidos insertarHistorial(HistorialPedidos historial) {
        return historialRepository.save(historial);
    }

    @Override
    public HistorialPedidos buscarHistorialPorId(Long id) {
        return historialRepository.findById(id).orElse(null);
    }

    @Override
    public HistorialPedidos editarHistorial(Long id, Long idPedido, Long idCliente, LocalDate fechaPedido) {
        HistorialPedidos historial = historialRepository.findById(id).orElse(null);
        if (historial != null) {
            historial.setIdPedidoProducto(idPedido);
            historial.setIdCliente(idCliente);
            historial.setFechaPedido(fechaPedido);
            return historialRepository.save(historial);
        }
        return null;
    }

    @Override
    public void eliminarHistorialPorId(Long id) {
        historialRepository.deleteById(id);
    }
}
