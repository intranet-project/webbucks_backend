package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Store;
import com.webbucks.Repository.StoreRepository;
import com.webbucks.admin.dto.AndroidStoreDto;
import org.springframework.web.client.RestTemplate;
/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신(인트라로부터 신규 매장 정보 가져오기)
 * */
@Service
public class AndroidStoreServiceImpl implements AndroidStoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ArrayList<AndroidStoreDto> getAllStores() {
        	List<AndroidStoreDto> storeData = storeRepository.findAll().stream()
    				.map(store -> AndroidStoreDto.builder()
    						.store_id(store.getStoreId())
    						.store_name(store.getStoreName())
    						.store_address(store.getStoreAddress())
    						.store_latitude(store.getStoreLatitude())
    						.store_longitude(store.getStoreLongitude())
    						.isFavorite(false).build())
    				.collect(Collectors.toList());
            return (ArrayList<AndroidStoreDto>) storeData;
        
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long id) {
    	storeRepository.deleteById(id);
    }

    // 1.1
    @Override
    public String getStore() {
        String url2= "http://localhost:9000/api/v1/intrabucks/manager/getstore";
        // GET 요청 보내기
        ResponseEntity<List<Store>> response = restTemplate.exchange(
                url2,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Store>>() {}
        );
        List<Store> stores = response.getBody();
        storeRepository.saveAll(stores);
        return "success";
    }
}
