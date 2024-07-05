package com.webbucks.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AndroidCustomerDto {
    private long cust_id;
    private String cust_name;
    private String cust_password;
    private String cust_email;
    private String cust_phone;
    private Date cust_created_at;
}
