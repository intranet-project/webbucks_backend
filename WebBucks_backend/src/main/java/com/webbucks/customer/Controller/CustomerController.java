package com.webbucks.customer.Controller;

import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;
import com.webbucks.customer.dto.voiceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.webbucks.customer.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
    @PostMapping("/voice")
    public String saveVoice(@RequestBody voiceRequestDto voice) {
        customerService.saveVoice(voice);
        return "Hello, world!";
    }

    @GetMapping("/getvoice")
    public Voice getVoice(@RequestParam("id") long voiceId) {
        return customerService.getVoice(voiceId);
    }
}

