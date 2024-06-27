package com.webbucks.Entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

/**
 * 포인트관리(선불카드) 테이블(Point) 엔티티로, 포인트 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Point")
@Data
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "point_id")
	private Long pointId; // 포인트 고유ID

	@ManyToOne
	@JoinColumn(name = "cust_id", nullable = false)
	private Customer customer; // 사용자 고유 ID

	@Column(name = "points", nullable = false)
	private int points; // 사용가능 한 포인트

	@Column(name = "point_created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date pointCreatedAt; // 포인트 충전 일자

	@Column(name = "point_update_at")
	@Temporal(TemporalType.DATE)
	private Date pointUpdateAt; // 포인트 사용 일자
}