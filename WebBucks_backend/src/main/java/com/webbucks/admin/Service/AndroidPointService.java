package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.Entity.Point;
import com.webbucks.admin.dto.AndroidPointDto;

public interface AndroidPointService {
	AndroidPointDto savePoints(AndroidPointDto androidPointDto);
	ArrayList<AndroidPointDto> getAllPoints();
    Point getPointsById(Long id);
    Point updatePoints(Point points);
    void deletePoints(Long id);
}
