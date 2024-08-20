package khly.codelean.project2.services;

import khly.codelean.project2.dtos.ProductDTO;
import khly.codelean.project2.entities.Product;
import khly.codelean.project2.exceptions.AppException;
import khly.codelean.project2.exceptions.ErrorCode;
import khly.codelean.project2.mappers.ProductMapper;
import khly.codelean.project2.models.CreateProductModel;
import khly.codelean.project2.models.UpdateProductModel;
import khly.codelean.project2.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductDTO createProduct(CreateProductModel createProductModel) {
        Product product = Product.builder()
                .name(createProductModel.getName())
                .price(createProductModel.getPrice())
                .description(createProductModel.getDescription())
                .image(createProductModel.getImage())
                .category(createProductModel.getCategory())
                .orderDetail(createProductModel.getOrderDetail())
                .build();
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, UpdateProductModel updateProductModel) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        product.setName(updateProductModel.getName());
        product.setPrice(updateProductModel.getPrice());
        product.setDescription(updateProductModel.getDescription());
        product.setImage(updateProductModel.getImage());
        product.setCategory(updateProductModel.getCategory());
        product.setOrderDetail(updateProductModel.getOrderDetail());
        productRepository.save(product);
        return productMapper.toProductDTO(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        productRepository.delete(product);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        return productMapper.toProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }
}
