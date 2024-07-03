package com.webbucks.admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Point;
import com.webbucks.Repository.PointRepository;

@Service
public class AndroidPointServiceImpl implements AndroidPointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Point savePoints(Point point) {
        return pointRepository.save(point);
    }

    @Override
    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    @Override
    public Point getPointsById(Long id) {
        return pointRepository.findById(id).orElse(null);
    }

    @Override
    public Point updatePoints(Point point) {
        return pointRepository.save(point);
    }

    @Override
    public void deletePoints(Long id) {
    	pointRepository.deleteById(id);
    }
}
