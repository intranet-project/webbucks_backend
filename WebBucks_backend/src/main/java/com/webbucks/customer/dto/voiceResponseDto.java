package com.webbucks.customer.dto;

import lombok.Data;

@Data
public class voiceResponseDto {
    Long custId;
    String voiceTitle;
    String voiceContent;
    Long storeId;
}
