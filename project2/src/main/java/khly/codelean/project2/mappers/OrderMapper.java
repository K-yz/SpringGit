package khly.codelean.project2.mappers;

import khly.codelean.project2.dtos.OrderDTO;
import khly.codelean.project2.entities.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toOrderDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .customer(order.getCustomer())
                .order_date(order.getOrder_date())
                .total_amount(order.getTotal_amount())
                .status(order.getStatus())
                .build();
    }
}
