package khly.codelean.project2.services;

import khly.codelean.project2.dtos.ProductDTO;
import khly.codelean.project2.models.CreateProductModel;
import khly.codelean.project2.models.UpdateProductModel;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(CreateProductModel createProductModel);
    ProductDTO updateProduct(Long id, UpdateProductModel updateProductModel);
    void deleteProduct(Long id);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
}
