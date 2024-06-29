package com.webbucks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbucks.Entity.Store;

/**
 * 매장관리 테이블(Store) 엔티티의 레포지토리
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

public interface StoreRepository extends JpaRepository<Store, Long>{
    Store findByStoreId(Long id);
}
