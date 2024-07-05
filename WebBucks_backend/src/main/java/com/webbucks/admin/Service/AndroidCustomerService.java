package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;

import com.webbucks.Entity.Customer;
import com.webbucks.admin.dto.AndroidCustomerDto;

public interface AndroidCustomerService {
	ArrayList<AndroidCustomerDto> getAllCustomers();
    Customer getCustomerById(Long id);
    AndroidCustomerDto saveCustomer(AndroidCustomerDto customer);
    List<Customer> saveAllCustomers(List<Customer> customers);
    void deleteCustomer(Long id);
}
