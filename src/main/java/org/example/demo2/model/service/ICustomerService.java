package org.example.demo2.model.service;

import org.example.demo2.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer c);
}
