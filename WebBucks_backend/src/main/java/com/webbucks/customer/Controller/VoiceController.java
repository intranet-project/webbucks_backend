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
/** 고객의 소리 Controller, 리액트 서버(프론트), 인트라넷 서버와 통신
 * @author  최유빈
 * @version 1.3
 * @since 2024.07.04
 * */
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


    /** 공홈에서 고객의 소리 답변 확인 */

    /* 리액트에서 조회 요청이 들어왔을 때 intranet에서 답변 받아오고 저장 */
    @GetMapping("/answer")
    public List<Voice> answer(@RequestParam("custId") long custId) {
        voiceService.getAnswer(custId);
        return voiceService.selectAllVoice();
    }
//------------------------------------------

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

