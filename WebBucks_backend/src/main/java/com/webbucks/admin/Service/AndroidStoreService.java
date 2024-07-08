package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;

import com.webbucks.Entity.Store;
import com.webbucks.admin.dto.AndroidStoreDto;
/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신(인트라로부터 신규 매장 정보 가져오기)
 * @since 2024-07-08
 * */
public interface AndroidStoreService {
	ArrayList<AndroidStoreDto> getAllStores();
    Store getStoreById(Long id);
    Store saveStore(Store store);
    void deleteStore(Long id);
    String getStore();// 1.1
}
