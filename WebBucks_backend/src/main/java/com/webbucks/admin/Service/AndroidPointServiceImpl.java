package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Customer;
import com.webbucks.Entity.Point;
import com.webbucks.Repository.PointRepository;
import com.webbucks.admin.dto.AndroidPointDto;

@Service
public class AndroidPointServiceImpl implements AndroidPointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public AndroidPointDto savePoints(AndroidPointDto androidPointDto) {
    	Point point = new Point();
    	Customer customer = new Customer();
    	customer.setCustId(androidPointDto.getCust_id());
    	point.setPointId(androidPointDto.getPoint_id());
    	point.setCustomer(customer);
    	point.setPoints(androidPointDto.getPoints());
    	point.setPointCreatedAt(androidPointDto.getPoint_created_at());
    	point.setPointUpdateAt(androidPointDto.getPoint_update_at());
    	pointRepository.save(point);
        return androidPointDto;
    }

    @Override
    public ArrayList<AndroidPointDto> getAllPoints() {
    	List<AndroidPointDto> menuData = pointRepository.findAll().stream()
				.map(point -> AndroidPointDto.builder()
						.point_id(point.getPointId())
						.cust_id(point.getCustomer().getCustId())
						.points(point.getPoints())
						.point_created_at(point.getPointCreatedAt())
						.point_update_at(point.getPointUpdateAt()).build())
				.collect(Collectors.toList());
        return (ArrayList<AndroidPointDto>) menuData;
    }

    @Override
    public AndroidPointDto getPointsById(Long id) {
    	Point point =  pointRepository.findByCustomerCustId(id);
    	AndroidPointDto androidPointDto = new AndroidPointDto();
    	androidPointDto.setPoint_id(point.getPointId());
    	androidPointDto.setCust_id(point.getCustomer().getCustId());
    	androidPointDto.setPoints(point.getPoints());
    	androidPointDto.setPoint_created_at(point.getPointCreatedAt());
    	androidPointDto.setPoint_update_at(point.getPointUpdateAt());
    	
        return androidPointDto;
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
