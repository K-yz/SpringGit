package khly.codelean.project2.models;

import jakarta.persistence.*;
import khly.codelean.project2.entities.Order;
import khly.codelean.project2.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateOrderDetailModel {
    private int quantity;

    private double price;

    @OneToMany(mappedBy = "orderDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
