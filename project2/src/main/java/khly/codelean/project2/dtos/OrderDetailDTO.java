package khly.codelean.project2.dtos;

import khly.codelean.project2.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO {
    private Long id;
    private int quantity;
    private double price;
    private Order order;
}
