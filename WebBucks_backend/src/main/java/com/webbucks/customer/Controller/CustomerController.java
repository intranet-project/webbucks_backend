package com.webbucks.customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.customer.Service.CustomerService;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
    @GetMapping("/test11")
    public String myTest() {
        return "Hello, world!";
    }
}

