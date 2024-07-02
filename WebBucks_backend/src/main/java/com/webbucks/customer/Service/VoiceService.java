package com.webbucks.customer.Service;

import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;

public interface VoiceService {
    String saveVoice(voiceRequestDto voice);
    Voice getVoice(long voiceId);
}
