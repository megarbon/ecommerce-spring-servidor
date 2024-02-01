package es.ecommerce.service;

import java.util.List;

import es.ecommerce.entity.Producto;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto insertarProducto(Producto producto);

    Producto buscarProductoPorId(Long id);

    Producto editarProducto(Long id, String nombre, String descripcion, Double precio, Integer stock, String imageUrl);

    void eliminarProductoPorId(Long id);
}
