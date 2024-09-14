package khly.codelean.project2.service.order;

import khly.codelean.project2.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAll();

    public Order findById(int theId);

    public void save(Order theOrder);

    public void deleteById(int theId);
}
