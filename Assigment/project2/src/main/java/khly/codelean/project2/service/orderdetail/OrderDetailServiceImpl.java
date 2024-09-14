package khly.codelean.project2.service.orderdetail;

import khly.codelean.project2.dao.OrderDetailRepository;
import khly.codelean.project2.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAllByOrderByIdAsc();
    }

    @Override
    public OrderDetail findById(int theId) {
        Optional<OrderDetail> result = orderDetailRepository.findById(theId);

        OrderDetail theOrderDetail = null;

        if (result.isPresent()) {
            theOrderDetail = result.get();
        } else {
            throw new RuntimeException("OrderDetail not found" + theId);
        }

        return theOrderDetail;
    }

    @Override
    public void save(OrderDetail theOrderDetail) {
        orderDetailRepository.save(theOrderDetail);
    }

    @Override
    public void deleteById(int theId) {
        orderDetailRepository.deleteById(theId);
    }
}
