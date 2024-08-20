package khly.codelean.project2.services;

import khly.codelean.project2.dtos.CategoryDTO;
import khly.codelean.project2.entities.Category;
import khly.codelean.project2.exceptions.AppException;
import khly.codelean.project2.exceptions.ErrorCode;
import khly.codelean.project2.mappers.CategoryMapper;
import khly.codelean.project2.models.CreateCategoryModel;
import khly.codelean.project2.models.UpdateCategoryModel;
import khly.codelean.project2.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createCategory(CreateCategoryModel createCategoryModel) {
        Category category = Category.builder()
                .name(createCategoryModel.getName())
                .build();
        categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(Long id, UpdateCategoryModel updateCategoryModel) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        category.setName(updateCategoryModel.getName());
        categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }
}
