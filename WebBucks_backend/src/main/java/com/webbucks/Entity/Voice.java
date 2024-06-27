package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

/**
 * 고객의 소리 테이블(Voice) 엔티티로, 고객의 소리에 대한정보를 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Voice")
@Data
public class Voice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voice_id") // 고객의 소리ID
    private long voiceId;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer; // 고객ID

    @Column(name = "voice_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date voiceDate; //등록일자

    @Column(name = "voice_title", nullable = false)
    private String voiceTitle; // 제목

    @Column(name = "voice_content", nullable = false)
    private String voiceContent; // 내용

    @Column(name = "answer_content", nullable = true)
    private String answerContent; // 답변

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store; // 매장ID

    @Column(name = "voice_state", nullable = false)
    private String voiceState; // 처리여부

    @Column(name = "answer_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date answerDate; // 처리날짜

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee; // 직원ID
}