package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.Store;

public interface AndroidStoreService {
    List<Store> getAllStores();
    Store getStoreById(Long id);
    Store saveStore(Store store);
    void deleteStore(Long id);
}
