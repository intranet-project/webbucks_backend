package com.webbucks.admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.admin.Service.AdminService;

@RestController
@RequestMapping(value = "/api")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	
    @GetMapping("/test")
    public String myTest() {
        return "Hello, world!";
    }
}

