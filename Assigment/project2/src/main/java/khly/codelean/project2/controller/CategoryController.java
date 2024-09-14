package khly.codelean.project2.controller;

import khly.codelean.project2.entity.Category;
import khly.codelean.project2.service.category.CategoryService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listCategory(Model theModel) {
        List<Category> theCategory = categoryService.findAll();
        theModel.addAttribute("categories", theCategory);
        return "admin/Category/list-categories";
    }

    @GetMapping("/add")
    public String addCategory(Model theModel) {
        Category theCategory = new Category();
        theModel.addAttribute("categories", theCategory);
        return "admin/Category/add-category-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("categoryId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Category theCategory = categoryService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("categories", theCategory);

        // send over to our form
        return "admin/Category/add-category-form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("categories") Category theCategory) {

        // save the Feedback
        categoryService.save(theCategory);

        // use a redirect to prevent duplicate submissions
        return "redirect:/categories/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("categoryId") int theId) {

        // delete the Feedback
        categoryService.deleteById(theId);

        // redirect to /Feedback/list
        return "redirect:/categories/list";

    }
}
