package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.models.Category;
import ra.com.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    @Transactional
    public Boolean create(Category category) {
        try{
            entityManager.persist(category);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @Transactional
    public Boolean update(Category category) {
        try{
            entityManager.merge(category);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        Category category = findById(id);
        if(category != null){
            entityManager.remove(category);
            return true;
        }
        return false;
    }
}
