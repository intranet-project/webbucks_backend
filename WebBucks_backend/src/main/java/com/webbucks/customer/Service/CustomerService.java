package com.webbucks.customer.Service;

import com.webbucks.Entity.Customer;
import com.webbucks.customer.dto.voiceRequestDto;

public interface CustomerService {
    void saveVoice(voiceRequestDto voice);
}
