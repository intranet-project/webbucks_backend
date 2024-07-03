package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.Customer;

public interface AndroidCustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    List<Customer> saveAllCustomers(List<Customer> customers);
    void deleteCustomer(Long id);
}
