package khly.codelean.project2.services;

import khly.codelean.project2.dtos.OrderDetailDTO;
import khly.codelean.project2.models.CreateOrderDetailModel;
import khly.codelean.project2.models.UpdateOrderDetailModel;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDTO createOrderDetail(CreateOrderDetailModel createEntryModel);
    OrderDetailDTO updateOrderDetail(Long id, UpdateOrderDetailModel updateOrderDetailModel);
    void deleteOrderDetail(Long id);
    OrderDetailDTO getOrderDetailById(Long id);
    List<OrderDetailDTO> getAllOrderDetails();
}
