package com.webbucks.customer.Service;

import com.webbucks.Entity.Employee;
import com.webbucks.Entity.Voice;
import com.webbucks.Repository.CustomerRepository;
import com.webbucks.Repository.StoreRepository;
import com.webbucks.Repository.VoiceRepository;
import com.webbucks.customer.dto.voiceRequestDto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private RestTemplate restTemplate;

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


        voiceRepository.save(voice);
        return null;
    }

    @Override
    public List<Voice> getVoice() {
        return voiceRepository.findAll();
    }


    @Override
    public String getAnswer(long custId) {
        String url = "http://localhost:9000/api/v1/intrabucks/customer/getanswer?custId="+custId;
        ResponseEntity<List<Voice>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Voice>>() {}
        );
        List<Voice> voices = response.getBody();
        voiceRepository.saveAll(voices);
        return "Success";
    }

    @Override
    public String getAnswerSyn() {
        String url = "http://localhost:9000/api/v1/intrabucks/customer/getanswerSyn";
        ResponseEntity<List<Voice>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Voice>>() {}
        );
        List<Voice> voices = response.getBody();
       voiceRepository.saveAll(voices);
        return "Success";
    }

    /*리액트로 보내는 고객의 소리와 답변*/
    @Override
    public List<Voice> selectAllVoice() {
        return voiceRepository.findAll();
    }
}
