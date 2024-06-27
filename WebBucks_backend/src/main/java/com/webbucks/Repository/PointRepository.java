package com.webbucks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbucks.Entity.Point;

/**
 * 포인트관리(선불카드) 테이블(Point) 엔티티의 레포지토리
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

public interface PointRepository extends JpaRepository<Point, Long>{

}
