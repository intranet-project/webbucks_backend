package com.webbucks.customer.Service;

import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;

import java.util.List;

public interface VoiceService {
    String saveVoice(voiceRequestDto voice);
    Voice getVoice(long voiceId);

    String getAnswer(long voiceId);
    List<Voice> selectAllVoice();

}
