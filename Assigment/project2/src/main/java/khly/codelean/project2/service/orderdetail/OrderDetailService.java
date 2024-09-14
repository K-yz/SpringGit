package khly.codelean.project2.service.orderdetail;

import khly.codelean.project2.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetail> findAll();

    public OrderDetail findById(int theId);

    public void save(OrderDetail theOrderDetail);

    public void deleteById(int theId);
}
