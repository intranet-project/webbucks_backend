package com.webbucks.customer.Service;

import com.webbucks.Entity.Employee;
import com.webbucks.Entity.Voice;
import com.webbucks.Repository.CustomerRepository;
import com.webbucks.Repository.StoreRepository;
import com.webbucks.Repository.VoiceRepository;
import com.webbucks.customer.dto.voiceRequestDto;
import com.webbucks.customer.dto.voiceResponseDto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Builder
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    VoiceRepository voiceRepository;
    CustomerRepository customerRepository;
    StoreRepository storeRepository;

    @Override
    public void saveVoice(voiceRequestDto customer) {
        Date today = new Date();
        Employee employee = new Employee();
        Voice voice = new Voice();
        voice.setCustomer(customerRepository.findByCustId(customer.getCustId()));
        voice.setStore(storeRepository.findByStoreId(customer.getStoreId()));
        voice.setVoiceTitle(customer.getVoiceTitle());
        voice.setVoiceContent(customer.getVoiceContent());
        voice.setAnswerDate(today);
        //voice.setEmployee(employee);

        voiceRepository.save(voice);
    }

    @Override
    public Voice getVoice(long voiceId) {
        return voiceRepository.findByVoiceId(voiceId);
    }
}
