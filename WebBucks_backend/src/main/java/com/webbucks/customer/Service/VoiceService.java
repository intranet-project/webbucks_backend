package com.webbucks.customer.Service;

import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;

import java.util.List;

public interface VoiceService {
    String saveVoice(voiceRequestDto voice);
    List<Voice> getVoice();

    String getAnswer(long custId);
    List<Voice> selectAllVoice();
    String getAnswer2();
}
