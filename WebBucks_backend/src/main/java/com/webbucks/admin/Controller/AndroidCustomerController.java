package com.webbucks.admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.Customer;
import com.webbucks.admin.Service.AndroidCustomerService;
import com.webbucks.admin.dto.AndroidCustomerDto;
import com.webbucks.admin.dto.AndroidMenuDto;

@RestController
@RequestMapping("/api/customers")
public class AndroidCustomerController {

    private static final Logger logger = LoggerFactory.getLogger(AndroidCustomerController.class);

    @Autowired
    private AndroidCustomerService customerService;

    // 고객 리스트를 반환하는 엔드포인트
    @GetMapping
    public ResponseEntity<ArrayList<AndroidCustomerDto>> getAllCustomers() {
        return new ResponseEntity<ArrayList<AndroidCustomerDto>>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    
    // 고객을 ID로 검색하는 엔드포인트
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // 새로운 고객을 저장하는 엔드포인트
    @PostMapping
    public ResponseEntity<AndroidCustomerDto> saveCustomer(@RequestBody AndroidCustomerDto customer) {
        return new ResponseEntity<AndroidCustomerDto>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    // 다수의 고객을 저장하는 엔드포인트
    @PostMapping("/batch")
    public List<Customer> saveCustomers(@RequestBody List<Customer> customers) {
        return customerService.saveAllCustomers(customers);
    }

    // 고객을 삭제하는 엔드포인트
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

//    // 회원가입 폼을 보여주는 엔드포인트
//    @GetMapping("/signup")
//    public String showSignupForm() {
//        return "signup";
//    }
//
//    // 회원가입 요청을 처리하는 엔드포인트
//    @PostMapping("/signup")
//    public String signupCustomer(
//        @RequestParam("cust_name") String custName,
//        @RequestParam("cust_password") String custPassword,
//        @RequestParam("cust_email") String custEmail,
//        @RequestParam("cust_phone") String custPhone,
//        Model model) {
//    	Customer customer = new Customer();
//        customer.setCustName(custName);
//        customer.setCustPassword(custPassword);
//        customer.setCustEmail(custEmail);
//        customer.setCustPhone(custPhone);
//        customer.setCustCreatedAt(new Date());  // 현재 시간을 설정
//        customerService.saveCustomer(customer);
//        model.addAttribute("message", "회원 가입이 완료되었습니다.");
//        return "redirect:/customers";
//    }
}
