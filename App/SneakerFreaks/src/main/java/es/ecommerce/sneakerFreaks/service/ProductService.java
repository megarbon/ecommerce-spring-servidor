package es.ecommerce.sneakerFreaks.service;

import es.ecommerce.sneakerFreaks.dao.ProductDAO;
import es.ecommerce.sneakerFreaks.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productDAO.findById(id);
        return optionalProduct.orElse(null);
    }

    public boolean existsById(Long id) {
        return productDAO.existsById(id);
    }

    public Product updateProduct(Product product) {
        return productDAO.save(product);
    }

    public Product createProduct(Product product) {
        return productDAO.save(product);
    }

    public void deleteProductById(Long id) {
        productDAO.deleteById(id);
    }

}
