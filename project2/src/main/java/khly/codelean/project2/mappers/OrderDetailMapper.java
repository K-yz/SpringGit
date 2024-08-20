package khly.codelean.project2.mappers;

import khly.codelean.project2.dtos.OrderDetailDTO;
import khly.codelean.project2.entities.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    public OrderDetailDTO toOrderDetailDTO(OrderDetail orderDetail) {
        return OrderDetailDTO.builder()
                .id(orderDetail.getId())
                .quantity(orderDetail.getQuantity())
                .price(orderDetail.getPrice())
                .order(orderDetail.getOrder())
                .build();
    }
}
