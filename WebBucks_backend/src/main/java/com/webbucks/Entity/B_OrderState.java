package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 주문관리 테이블(B_OrderState) 엔티티로,  주문 상태 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "B_OrderState")
@Data
public class B_OrderState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_order_status_id")
	private Long b_orderStatusId; // 상태ID

	@ManyToOne
	@JoinColumn(name = "b_order_id", nullable = false)
	private B_Order order; // 주문ID

	@Column(name = "b_order_state", nullable = false)
	private String b_orderState; // 주문 상태

	@Column(name = "b_order_state_update_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date b_orderStateUpdateAt; // 주문 상태 업데이트 일자
}