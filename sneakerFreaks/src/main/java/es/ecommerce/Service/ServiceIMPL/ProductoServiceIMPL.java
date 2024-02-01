package es.ecommerce.service.serviceIMPL;

import es.ecommerce.entity.Producto;
import es.ecommerce.repository.ProductoRepository;
import es.ecommerce.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceIMPL implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Producto insertarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto editarProducto(Long id, String nombre, String descripcion, Double precio, Integer stock,
            String imageUrl) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setImageUrl(imageUrl);
            return productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        productoRepository.deleteById(id);
    }
}
