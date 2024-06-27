package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 주문관리 테이블(Manager) 엔티티로,  지점 관리자 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Managers")
@Data
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private Long managerId; // 관리자 고유 ID

	@Column(name = "manager_name", nullable = false)
	private String managerName; // 관리자 이름

	@Column(name = "manager_password", nullable = false)
	private String managerPassword; // 관리자 비밀ID

	@Column(name = "manager_email", nullable = false)
	private String managerEmail; // 관리자 이메일

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store; // 담당 매장 고유 ID
}