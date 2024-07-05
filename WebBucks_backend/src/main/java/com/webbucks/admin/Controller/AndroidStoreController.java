package com.webbucks.admin.Controller;

import java.util.ArrayList;

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


@RestController
@RequestMapping("/api/stores")
public class AndroidStoreController {

    private static final Logger logger = LoggerFactory.getLogger(AndroidStoreController.class);

    @Autowired
    private AndroidStoreService storesService;

    @GetMapping
    public ResponseEntity<ArrayList<AndroidStoreDto>> getAllStores() {
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
