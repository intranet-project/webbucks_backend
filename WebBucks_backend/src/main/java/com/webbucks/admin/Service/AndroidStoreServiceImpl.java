package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Store;
import com.webbucks.Repository.StoreRepository;
import com.webbucks.admin.dto.AndroidStoreDto;

@Service
public class AndroidStoreServiceImpl implements AndroidStoreService {

    @Autowired
    private StoreRepository storeRepository;

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
}
