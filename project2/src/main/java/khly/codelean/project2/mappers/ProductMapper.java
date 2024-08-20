package khly.codelean.project2.mappers;

import khly.codelean.project2.dtos.ProductDTO;
import khly.codelean.project2.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImage())
                .category(product.getCategory())
                .orderDetail(product.getOrderDetail())
                .build();
    }
}
