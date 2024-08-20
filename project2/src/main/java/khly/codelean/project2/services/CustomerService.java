package khly.codelean.project2.services;

import khly.codelean.project2.dtos.CustomerDTO;
import khly.codelean.project2.models.CreateCustomerModel;
import khly.codelean.project2.models.UpdateCustomerModel;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CreateCustomerModel createCustomerModel);
    CustomerDTO updateCustomer(Long id, UpdateCustomerModel updateCustomerModel);
    void deleteCustomer(Long id);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
}
