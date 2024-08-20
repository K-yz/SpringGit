package khly.codelean.project2.dtos;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import khly.codelean.project2.entities.Category;
import khly.codelean.project2.entities.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String price;
    private String description;
    private String image;
    private OrderDetail orderDetail;
    private Category category;
}
