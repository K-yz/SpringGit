package org.example.coffeeshop.service;

import org.example.coffeeshop.entity.Customer;

import java.util.List;

public interface CustomerService {

    public void save(Customer theCustomer);

    public List<Customer> findAll();

    public Customer findById(int theId);

    public void deleteById(int theId);
}
