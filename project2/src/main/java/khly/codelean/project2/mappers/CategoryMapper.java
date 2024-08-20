package khly.codelean.project2.mappers;

import khly.codelean.project2.dtos.CategoryDTO;
import khly.codelean.project2.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
