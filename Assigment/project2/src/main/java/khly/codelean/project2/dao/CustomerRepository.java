package khly.codelean.project2.dao;

import khly.codelean.project2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public List<Customer> findAllByOrderByNameAsc();
}
