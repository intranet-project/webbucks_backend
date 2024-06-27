package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 매장관리 테이블(Store) 엔티티로, 매장 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Store")
@Data
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Long storeId; // 매장 고유 ID

	@Column(name = "store_name", nullable = false)
	private String storeName; // 매장 이름

	@Column(name = "store_latitude", nullable = false, precision = 10, scale = 8)
	private double storeLatitude; // 매장 위도

	@Column(name = "store_longitude", nullable = false, precision = 11, scale = 8)
	private double storeLongitude; // 매장 경도

	@Column(name = "store_address", nullable = false)
	private String storeAddress; // 매장 주소

	@Column(name = "store_created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date storeCreatedAt; // 매장 등록 일자
}