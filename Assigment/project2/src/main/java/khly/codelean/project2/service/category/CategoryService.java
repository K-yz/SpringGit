package khly.codelean.project2.service.category;

import khly.codelean.project2.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(int theId);

    public void save(Category theCategory);

    public void deleteById(int theId);
}
