package org.example.coffeeshop.dao;

import org.example.coffeeshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
    List<Customer> findAllByOrderByName();
}
