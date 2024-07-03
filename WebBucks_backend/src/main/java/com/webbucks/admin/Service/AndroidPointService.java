package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.Point;

public interface AndroidPointService {
	Point savePoints(Point points);
    List<Point> getAllPoints();
    Point getPointsById(Long id);
    Point updatePoints(Point points);
    void deletePoints(Long id);
}
