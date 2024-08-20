package khly.codelean.project2.controller;

import khly.codelean.project2.dtos.CategoryDTO;
import khly.codelean.project2.dtos.ResponseObject;
import khly.codelean.project2.models.CreateCategoryModel;
import khly.codelean.project2.models.UpdateCategoryModel;
import khly.codelean.project2.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ResponseObject> createCategory(@RequestBody CreateCategoryModel createCategoryModel) {
        CategoryDTO categoryDTO = categoryService.createCategory(createCategoryModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseObject(true, HttpStatus.CREATED.value(), "Entry created successfully", categoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateEntry(@PathVariable Long id, @RequestBody UpdateCategoryModel updateCategoryModel) {
        CategoryDTO categoryDTO = categoryService.updateCategory(id, updateCategoryModel);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entry updated successfully", categoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entry deleted successfully", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getCategoryById(@PathVariable Long id) {
        CategoryDTO entryDTO = categoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entry retrieved successfully", entryDTO));
    }

    @GetMapping
    public ResponseEntity<ResponseObject> getAllCategory() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entries retrieved successfully", categories));
    }
}
