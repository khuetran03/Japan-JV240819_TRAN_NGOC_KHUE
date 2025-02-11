package ra.com.service;

import ra.com.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean create(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean delete(int id);

}
