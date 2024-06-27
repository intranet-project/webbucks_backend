package com.webbucks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbucks.Entity.Voice;

/**
 * 고객의 소리 테이블(Voice) 엔티티의 레포지토리
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

public interface VoiceRepository extends JpaRepository<Voice, Long>{

}
