package es.ecommerce.Service;

import es.ecommerce.Entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto insertarProducto(Producto producto);

    Producto buscarProductoPorId(Long id);

    Producto editarProducto(Long id, String nombre, String descripcion, Double precio, Integer stock, String imageUrl);

    void eliminarProductoPorId(Long id);
}
