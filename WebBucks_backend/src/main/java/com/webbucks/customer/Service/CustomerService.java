package com.webbucks.customer.Service;

import com.webbucks.Entity.Customer;
import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;
import com.webbucks.customer.dto.voiceResponseDto;

public interface CustomerService {
    void saveVoice(voiceRequestDto voice);
    Voice getVoice(long voiceId);
}
