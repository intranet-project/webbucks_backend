package com.webbucks.customer.dto;

import lombok.Data;

@Data
public class voiceRequestDto {
    Long custId;
    String voiceTitle;
    String voiceContent;
    Long storeId;
}
