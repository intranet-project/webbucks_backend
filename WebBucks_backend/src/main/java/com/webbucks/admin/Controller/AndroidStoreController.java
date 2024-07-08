package com.webbucks.admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.Store;
import com.webbucks.admin.Service.AndroidStoreService;
import com.webbucks.admin.dto.AndroidStoreDto;
/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신(인트라로부터 신규 매장 정보 가져오기)
 * */

@RestController
@RequestMapping("/api/stores")
public class AndroidStoreController {

    private static final Logger logger = LoggerFactory.getLogger(AndroidStoreController.class);

    @Autowired
    private AndroidStoreService storesService;

    @GetMapping
    public ResponseEntity<ArrayList<AndroidStoreDto>> getAllStores() {
    	storesService.getStore(); //1.1
        return new ResponseEntity<ArrayList<AndroidStoreDto>>(storesService.getAllStores(), HttpStatus.OK);
    }
   
    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storesService.getStoreById(id);
    }

    @PostMapping
    public Store saveStore(@RequestBody Store store) {
        logger.info("Received store: {}", store);
        return storesService.saveStore(store);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storesService.deleteStore(id);
    }



}
