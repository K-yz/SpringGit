package khly.codelean.project2.models;

import jakarta.persistence.*;
import khly.codelean.project2.entities.Customer;
import khly.codelean.project2.entities.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UpdateOrderModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    private LocalDateTime order_date;

    private String total_amount;

    private String status;
}
