package khly.codelean.project2.services;

import khly.codelean.project2.dtos.OrderDetailDTO;
import khly.codelean.project2.entities.OrderDetail;
import khly.codelean.project2.exceptions.AppException;
import khly.codelean.project2.exceptions.ErrorCode;
import khly.codelean.project2.mappers.OrderDetailMapper;
import khly.codelean.project2.models.CreateOrderDetailModel;
import khly.codelean.project2.models.UpdateOrderDetailModel;
import khly.codelean.project2.repositories.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetailDTO createOrderDetail(CreateOrderDetailModel createOrderDetailModel) {
        OrderDetail orderDetail = OrderDetail.builder()
                .quantity(createOrderDetailModel.getQuantity())
                .price(createOrderDetailModel.getPrice())
                .order(createOrderDetailModel.getOrder())
                .build();
        orderDetailRepository.save(orderDetail);
        return orderDetailMapper.toOrderDetailDTO(orderDetail);
    }

    @Override
    public OrderDetailDTO updateOrderDetail(Long id, UpdateOrderDetailModel updateOrderDetailModel) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        orderDetail.setQuantity(updateOrderDetailModel.getQuantity());
        orderDetail.setPrice(updateOrderDetailModel.getPrice());
        orderDetail.setOrder(updateOrderDetailModel.getOrder());
        orderDetailRepository.save(orderDetail);
        return orderDetailMapper.toOrderDetailDTO(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        orderDetailRepository.delete(orderDetail);
    }

    @Override
    public OrderDetailDTO getOrderDetailById(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        return orderDetailMapper.toOrderDetailDTO(orderDetail);
    }

    @Override
    public List<OrderDetailDTO> getAllOrderDetails() {
        return orderDetailRepository.findAll()
                .stream()
                .map(orderDetailMapper::toOrderDetailDTO)
                .collect(Collectors.toList());
    }
}
