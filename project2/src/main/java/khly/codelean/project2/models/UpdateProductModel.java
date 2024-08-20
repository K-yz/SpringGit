package khly.codelean.project2.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import khly.codelean.project2.entities.Category;
import khly.codelean.project2.entities.OrderDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductModel {
    private String name;
    private String price;
    private String description;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderDetail_id")
    private OrderDetail orderDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
