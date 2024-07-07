package com.webbucks.admin.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.Point;
import com.webbucks.admin.Service.AndroidPointService;
import com.webbucks.admin.dto.AndroidPointDto;

@RestController
@RequestMapping("/api/points")
public class AndroidPointController {

    @Autowired
    private AndroidPointService pointsService;

    @PostMapping
    public ResponseEntity<AndroidPointDto> savePoints(@RequestBody AndroidPointDto androidPointDto) {
    	return ResponseEntity.ok(pointsService.savePoints(androidPointDto));
    }

    @GetMapping
    public ResponseEntity<ArrayList<AndroidPointDto>> getAllPoints() {
        return ResponseEntity.ok(pointsService.getAllPoints());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Point> getPointsById(@PathVariable Long id) {
        return ResponseEntity.ok(pointsService.getPointsById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Point> updatePoints(@PathVariable Long id, @RequestBody Point point) {
        point.setPointId(id);
        return ResponseEntity.ok(pointsService.updatePoints(point));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoints(@PathVariable Long id) {
        pointsService.deletePoints(id);
        return ResponseEntity.noContent().build();
    }

    // 포인트 데이터를 받아오는 엔드포인트 추가
    @PostMapping("/receive")
    public ResponseEntity<AndroidPointDto> receivePoints(@RequestBody AndroidPointDto androidPointDto) {
    	return ResponseEntity.ok(pointsService.savePoints(androidPointDto));
    }
}
