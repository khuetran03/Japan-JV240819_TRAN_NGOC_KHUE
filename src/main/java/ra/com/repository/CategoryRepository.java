package ra.com.repository;

import ra.com.models.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Boolean create(Category category);
    Category findById(int id);
    Boolean update(Category category);
    Boolean delete(int id);
}
