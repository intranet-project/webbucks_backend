package com.webbucks.customer.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class voiceRequestDto {
    Long custId; // 고객ID
    String voiceTitle; // 고객의소리 제목
    String voiceContent; // 고객의소리 내용
    Long storeId; // 매장ID


    public voiceRequestDto(Long custId, Long storeId, String voiceTitle, String voiceContent, LocalDateTime createdAt) {
        this.custId = custId;
        this.storeId = storeId;
        this.voiceTitle = voiceTitle;
        this.voiceContent = voiceContent;
    }
}
