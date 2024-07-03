package com.webbucks.admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Store;
import com.webbucks.Repository.StoreRepository;

@Service
public class AndroidStoreServiceImpl implements AndroidStoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
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
