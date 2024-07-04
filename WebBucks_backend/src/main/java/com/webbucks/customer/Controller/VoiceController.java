package com.webbucks.customer.Controller;

import com.webbucks.Entity.Voice;
import com.webbucks.customer.dto.voiceRequestDto;
import com.webbucks.customer.dto.voiceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webbucks.customer.Service.VoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
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
    public List<Voice> getVoice() {
        return voiceService.getVoice();
    }

    //------------------------------------------

    /* 리액트에서 조회 요청이 들어왔을 때 intranet에서 답변 받아오고 저장 */
    @GetMapping("/answer")
    public List<Voice> answer(@RequestParam long voiceId) {
        voiceService.getAnswer(voiceId);
        return voiceService.selectAllVoice();
    }
//
//    /* 공홈 리액트에서 답변 조회*/
//    @GetMapping("/getanswer")
//    public List<Voice> getanswer(@RequestParam int voiceId) {
//        public List<Voice> getVoice() {
//            return voiceService.selectAllVoice();
//        }
//}
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

