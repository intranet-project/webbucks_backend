package com.webbucks.customer.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class voiceResponseDto {
    Long custId; // 고객ID
    String voiceTitle; // 고객의소리 제목
    String voiceContent; // 고객의소리 내용
    Long storeId; // 매장ID
    LocalDateTime voiceDate; // 생성 날짜

}
