package khly.codelean.project2.services;

import khly.codelean.project2.dtos.CategoryDTO;
import khly.codelean.project2.models.CreateCategoryModel;
import khly.codelean.project2.models.UpdateCategoryModel;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CreateCategoryModel createCategoryModel);
    CategoryDTO updateCategory(Long id, UpdateCategoryModel updateCategoryModel);
    void deleteCategory(Long id);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
}
