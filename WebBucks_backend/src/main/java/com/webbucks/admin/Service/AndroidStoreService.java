package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;

import com.webbucks.Entity.Store;
import com.webbucks.admin.dto.AndroidStoreDto;

public interface AndroidStoreService {
	ArrayList<AndroidStoreDto> getAllStores();
    Store getStoreById(Long id);
    Store saveStore(Store store);
    void deleteStore(Long id);
    String getStore();// 인트라 호출
}
