package khly.codelean.project2.service.customer;

import khly.codelean.project2.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public Customer findById(int theId);

    public void save(Customer theCustomer);

    public void deleteById(int theId);
}
