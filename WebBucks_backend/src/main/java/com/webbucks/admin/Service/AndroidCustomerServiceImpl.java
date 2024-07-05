package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Customer;
import com.webbucks.Entity.Menu;
import com.webbucks.Repository.CustomerRepository;
import com.webbucks.admin.dto.AndroidCustomerDto;
import com.webbucks.admin.dto.AndroidMenuDto;

@Service
public class AndroidCustomerServiceImpl implements AndroidCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ArrayList<AndroidCustomerDto> getAllCustomers() {
    	List<AndroidCustomerDto> customerData = customerRepository.findAll().stream()
				.map(customer -> AndroidCustomerDto.builder()
						.cust_id(customer.getCustId())
						.cust_name(customer.getCustName())
						.cust_password(customer.getCustPassword())
						.cust_email(customer.getCustEmail())
						.cust_phone(customer.getCustPhone())
						.cust_created_at(customer.getCustCreatedAt()).build())
				.collect(Collectors.toList());
        return (ArrayList<AndroidCustomerDto>) customerData;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public AndroidCustomerDto saveCustomer(AndroidCustomerDto androidCustomerDto) {
    	System.out.println("확인용 : "+androidCustomerDto);
    	Customer customer = new Customer(); 
    	customer.setCustId(androidCustomerDto.getCust_id());
    	customer.setCustName(androidCustomerDto.getCust_name());
    	customer.setCustPassword(androidCustomerDto.getCust_password());
    	customer.setCustEmail(androidCustomerDto.getCust_email());
    	customer.setCustPhone(androidCustomerDto.getCust_phone());
    	customer.setCustCreatedAt(androidCustomerDto.getCust_created_at());
    	customer.setCustGender("여성");
    	customer.setCustAge(30);
    	customerRepository.save(customer);
        return androidCustomerDto;
    }

    @Override
    public List<Customer> saveAllCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
