package khly.codelean.project2.repositories;

import khly.codelean.project2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
