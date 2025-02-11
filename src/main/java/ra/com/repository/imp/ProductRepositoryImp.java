package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.models.Category;
import ra.com.models.Product;
import ra.com.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    @Transactional
    public boolean create(Product product) {
        try {
            entityManager.persist(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
            return true;
        }
        return false;
    }
}
