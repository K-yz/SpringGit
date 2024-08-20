package khly.codelean.project2.repositories;

import khly.codelean.project2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
