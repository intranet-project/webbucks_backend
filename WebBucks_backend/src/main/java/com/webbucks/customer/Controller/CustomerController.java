package com.webbucks.customer.Controller;

import com.webbucks.admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
	
	@Autowired
	private AdminService adminService;

	
    @GetMapping("/test")
    public String myTest() {
        return "Hello, world!";
    }
}

