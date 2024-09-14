package khly.codelean.project2.service.customer;

import khly.codelean.project2.dao.CustomerRepository;
import khly.codelean.project2.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        } else {
            throw new RuntimeException("Customer not found" + theId);
        }

        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
