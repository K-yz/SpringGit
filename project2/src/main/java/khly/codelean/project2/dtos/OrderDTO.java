package khly.codelean.project2.dtos;

import khly.codelean.project2.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private Customer customer;
    private LocalDateTime order_date;
    private String total_amount;
    private String status;
}
