package khly.codelean.project2.services;

import khly.codelean.project2.dtos.OrderDTO;
import khly.codelean.project2.models.CreateOrderModel;
import khly.codelean.project2.models.UpdateOrderModel;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(CreateOrderModel createOrderModel);
    OrderDTO updateOrder(Long id, UpdateOrderModel updateOrderModel);
    void deleteOrder(Long id);
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
}
