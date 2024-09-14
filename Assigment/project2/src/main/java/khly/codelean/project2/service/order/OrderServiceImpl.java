package khly.codelean.project2.service.order;

import khly.codelean.project2.dao.OrderRepository;
import khly.codelean.project2.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Order findById(int theId) {
        Optional<Order> result = orderRepository.findById(theId);

        Order theOrder = null;

        if (result.isPresent()) {
            theOrder = result.get();
        } else {
            throw new RuntimeException("Order not found" + theId);
        }

        return theOrder;
    }

    @Override
    public void save(Order theOrder) {
        orderRepository.save(theOrder);
    }

    @Override
    public void deleteById(int theId) {
        orderRepository.deleteById(theId);
    }
}
