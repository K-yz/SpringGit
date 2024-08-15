package org.example.coffeeshop.service;

import org.example.coffeeshop.dao.CustomerRepository;
import org.example.coffeeshop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicelmpl {
    private final CustomerRepository customerRepository ;

    @Autowired
    public CustomerServicelmpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
