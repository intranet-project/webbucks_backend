package com.webbucks.customer.Controller;

import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;
import com.webbucks.customer.dto.voiceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webbucks.customer.Service.VoiceService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class VoiceController {

    private static final Logger logger = LoggerFactory.getLogger(VoiceController.class);
	@Autowired
	private VoiceService voiceService;

    /** 고객의 소리 (공홈 -> 인트라넷) */
	// 공홈에서 들어온 값 저장
    @PostMapping("/voice")
    public String saveVoice(@RequestBody voiceRequestDto voice) {
        logger.info("Received voice registration request: {}", voice);

        return voiceService.saveVoice(voice);
    }

    // intranet에서 요청이 들어왔을때(서버통신시)
    @GetMapping("/getvoice")
    public Voice getVoice(@RequestParam("id") long voiceId) {
        return voiceService.getVoice(voiceId);
    }

//    /* intranet에서 답변 받아오기 */
//    @PostMapping("/voiceAnswer")
//    public String saveAnswer(@RequestBody voiceResponseDto voice) {
//        return voiceService.saveAnswer(Answer);
//    }
//    /* 리액트로 답변 보내기 */
//    @GetMapping("/voiceAnswer")
//    public String sendAnswer(@RequestParam("id") long voiceId) {
//        return voiceService.sendAnswer(Answer);
//    }
}

