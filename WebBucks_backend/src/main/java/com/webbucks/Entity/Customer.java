package com.webbucks.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * 고객(Customer) 엔티티로, 고객에 대한 기본 정보를 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long custId; // 고객ID

    @Column(name = "cust_name", nullable = false)
    private String custName; // 이름

    @Column(name = "cust_password", nullable = false)
    private String custPassword; // 비밀ID

    @Column(name = "cust_email", nullable = false, unique = true)
    private String custEmail; // 이메일

    @Column(name = "cust_phone", nullable = false)
    private String custPhone; // 핸드폰

    @Column(name = "cust_created_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date custCreatedAt; // 가입일

    @Column(name = "cust_gender", nullable = false)
    private String custGender; // 성별

    @Column(name = "cust_age", nullable = false)
    private int custAge; // 나이
}

