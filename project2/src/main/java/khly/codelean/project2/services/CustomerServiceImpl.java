package khly.codelean.project2.services;

import khly.codelean.project2.dtos.CustomerDTO;
import khly.codelean.project2.entities.Customer;
import khly.codelean.project2.exceptions.AppException;
import khly.codelean.project2.exceptions.ErrorCode;
import khly.codelean.project2.mappers.CustomerMapper;
import khly.codelean.project2.models.CreateCustomerModel;
import khly.codelean.project2.models.UpdateCustomerModel;
import khly.codelean.project2.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO createCustomer(CreateCustomerModel createCustomerModel) {
        Customer customer = Customer.builder()
                .name(createCustomerModel.getName())
                .email(createCustomerModel.getEmail())
                .phone(createCustomerModel.getPhone())
                .address(createCustomerModel.getAddress())
                .build();
        customerRepository.save(customer);
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, UpdateCustomerModel updateCustomerModel) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        customer.setName(updateCustomerModel.getName());
        customer.setEmail(updateCustomerModel.getEmail());
        customer.setPhone(updateCustomerModel.getPhone());
        customer.setAddress(updateCustomerModel.getAddress());
        customerRepository.save(customer);
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND));
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }
}
