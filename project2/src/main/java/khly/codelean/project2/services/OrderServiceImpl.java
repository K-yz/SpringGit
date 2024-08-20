package khly.codelean.project2.services;

import khly.codelean.project2.dtos.OrderDTO;
import khly.codelean.project2.entities.Order;
import khly.codelean.project2.exceptions.AppException;
import khly.codelean.project2.exceptions.ErrorCode;
import khly.codelean.project2.mappers.OrderMapper;
import khly.codelean.project2.models.CreateOrderModel;
import khly.codelean.project2.models.UpdateOrderModel;
import khly.codelean.project2.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public OrderDTO createOrder(CreateOrderModel createOrderModel) {
        Order order = Order.builder()
                .customer(createOrderModel.getCustomer())
                .order_date(createOrderModel.getOrder_date())
                .total_amount(createOrderModel.getTotal_amount())
                .status(createOrderModel.getStatus())
                .build();
        orderRepository.save(order);
        return orderMapper.toOrderDTO(order);
    }

    @Override
    public OrderDTO updateOrder(Long id, UpdateOrderModel updateOrderModel) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        order.setStatus(updateOrderModel.getStatus());
        order.setOrder_date(updateOrderModel.getOrder_date());
        order.setTotal_amount(updateOrderModel.getTotal_amount());
        orderRepository.save(order);
        return orderMapper.toOrderDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        orderRepository.delete(order);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        return orderMapper.toOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }
}
