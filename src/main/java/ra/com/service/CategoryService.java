package ra.com.service;

import ra.com.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    boolean create(Category category);
    Category findById(int id);
    boolean update(Category category);
    boolean delete(int id);
}
