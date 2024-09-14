package khly.codelean.project2.service.category;

import khly.codelean.project2.dao.CategoryRepository;
import khly.codelean.project2.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Category findById(int theId) {
        Optional<Category> result = categoryRepository.findById(theId);

        Category theCategory = null;

        if (result.isPresent()) {
            theCategory = result.get();
        } else {
            throw new RuntimeException("Category not found" + theId);
        }

        return theCategory;
    }

    @Override
    public void save(Category theCategory) {
        categoryRepository.save(theCategory);
    }

    @Override
    public void deleteById(int theId) {
        categoryRepository.deleteById(theId);
    }
}
