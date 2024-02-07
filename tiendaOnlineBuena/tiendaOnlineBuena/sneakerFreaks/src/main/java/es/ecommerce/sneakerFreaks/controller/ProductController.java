package es.ecommerce.sneakerFreaks.controller;

import es.ecommerce.sneakerFreaks.model.Product;
import es.ecommerce.sneakerFreaks.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
        try {
            // Obtener los campos del cuerpo de la solicitud
            String name = body.get("name");
            String shortDescription = body.get("shortDescription");
            Double price = Double.parseDouble(body.get("price"));
            Double stock = Double.parseDouble(body.get("stock"));
            String image_url = body.get("image_url");

            // Crear un objeto Product con los datos recibidos
            Product updatedProduct = new Product(id, name, shortDescription, price, stock, image_url);

            // Actualizar el producto
            updatedProduct = productService.updateProduct(updatedProduct);

            // Comprobar si se actualizó correctamente
            if (updatedProduct != null) {
                return ResponseEntity.ok(updatedProduct);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (NumberFormatException e) {
            // Manejar error de conversión de tipos
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint para crear un nuevo producto
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            // Asignar manualmente un ID si es necesario
            // product.setId(1L); // Aquí puedes asignar el ID manualmente si lo deseas

            // Insertar el producto en la base de datos
            Product createdProduct = productService.createProduct(product);

            // Devolver una respuesta con el producto insertado y el código de estado 201
            // (CREATED)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);

        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante el proceso de inserción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    // Endpoint para eliminar un producto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
