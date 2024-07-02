package com.webbucks.customer.Service;

import com.webbucks.Entity.Employee;
import com.webbucks.Entity.Voice;
import com.webbucks.Repository.CustomerRepository;
import com.webbucks.Repository.StoreRepository;
import com.webbucks.Repository.VoiceRepository;
import com.webbucks.customer.dto.voiceRequestDto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

/** 고객의 소리 서비스
 * @author  최유빈
 * @since 2024.06.29
 * */

@Builder
@Service
public class VoiceServiceImpl implements VoiceService {
    @Autowired
    VoiceRepository voiceRepository;
    CustomerRepository customerRepository;
    StoreRepository storeRepository;

    /**
     * 리액트 화면 -> 공홈 서버
     * 공홈에서 고객이 입력한 고객의 소리 정보를 저장
     * 작성일, 매장명, 제목, 내용
     *
     * @return
     */
    @Override
    public String saveVoice(voiceRequestDto voiceRequestDto) {
        Date today = new Date();
        Employee employee = new Employee();
        Voice voice = new Voice();
        voice.setCustomer(customerRepository.findByCustId(voiceRequestDto.getCustId()));
        voice.setStore(storeRepository.findByStoreId(voiceRequestDto.getStoreId()));
        voice.setVoiceTitle(voiceRequestDto.getVoiceTitle());
        voice.setVoiceContent(voiceRequestDto.getVoiceContent());
        voice.setVoiceDate(today);
        //voice.setEmployee(employee);

        voiceRepository.save(voice);
        return null;
    }

    @Override
    public Voice getVoice(long voiceId) {
        return voiceRepository.findByVoiceId(voiceId);
    }
}
