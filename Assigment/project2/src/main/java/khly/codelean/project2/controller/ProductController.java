package khly.codelean.project2.controller;

import khly.codelean.project2.entity.Category;
import khly.codelean.project2.entity.OrderDetail;
import khly.codelean.project2.entity.Product;
import khly.codelean.project2.service.category.CategoryService;
import khly.codelean.project2.service.order.OrderService;
import khly.codelean.project2.service.orderdetail.OrderDetailService;
import khly.codelean.project2.service.product.ProductService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService, OrderDetailService orderDetailService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listProduct(Model theModel) {
        List<Product> theProduct = productService.findAll();
        theModel.addAttribute("products", theProduct);
        return "/admin/Product/list-products";
    }

    /*@GetMapping("/add")
    public String addProduct(Model theModel) {
        Product theProduct = new Product();
        theModel.addAttribute("products", theProduct);
        return "Product/add-product-form";
    }*/
    @GetMapping("/add")
    public String addProduct(Model theModel) {
        Product theProduct = new Product();

        // Fetch the list of categories and order details from the database
        List<Category> categories = categoryService.findAll();

        // Add them to the model
        theModel.addAttribute("products", theProduct);
        theModel.addAttribute("categories", categories);

        return "/admin/Product/add-product-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Product theProduct = productService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("products", theProduct);

        // send over to our form
        return "/admin/Product/add-product-form";
    }

    /*@PostMapping("/save")
    public String saveProduct(@ModelAttribute("products") Product theProduct) {

        // save the Feedback
        productService.save(theProduct);

        // use a redirect to prevent duplicate submissions
        return "redirect:/products/list";
    }*/

    /*@PostMapping("/save")
    public String saveProduct(@ModelAttribute("products") Product theProduct) {
        // Fetch the category based on its ID
        Category category = categoryService.findById(theProduct.getCategory().getId());

        // Set the category to the product
        theProduct.setCategory(category);

        // Save the product
        productService.save(theProduct);

        return "redirect:/products/list";
    }*/

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("products") Product theProduct,
                              @RequestParam("imageFile") MultipartFile imageFile) {
        Category category = categoryService.findById(theProduct.getCategory().getId());
        theProduct.setCategory(category);
        // Nếu người dùng tải lên file ảnh
        if (!imageFile.isEmpty()) {
            try {
                // Đường dẫn để lưu trữ file
                String uploadDir = "src/main/resources/static/images/";
                String fileName = imageFile.getOriginalFilename();

                // Lưu file ảnh vào server
                Path path = Paths.get(uploadDir + fileName);
                Files.write(path, imageFile.getBytes());

                // Lưu đường dẫn của file ảnh vào product
                theProduct.setImage("/images/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý lỗi
            }
        }

        // Lưu sản phẩm vào database
        productService.save(theProduct);

        return "redirect:/products/list";
    }




    @PostMapping("/delete")
    public String delete(@RequestParam("productId") int theId) {

        // delete the Feedback
        productService.deleteById(theId);

        // redirect to /Feedback/list
        return "redirect:/products/list";

    }
}
