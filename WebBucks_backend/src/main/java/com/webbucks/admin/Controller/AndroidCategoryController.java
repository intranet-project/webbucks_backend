package com.webbucks.admin.Controller;

import java.util.ArrayList;

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

import com.webbucks.Entity.Category;
import com.webbucks.admin.Service.AndroidCategoryService;
import com.webbucks.admin.dto.AndroidCategoryDto;

@RestController
@RequestMapping("/api/categories")
public class AndroidCategoryController {

    @Autowired
    private AndroidCategoryService categoriesService;

  
    @GetMapping
    public ResponseEntity<ArrayList<AndroidCategoryDto>> getAllCategories() {
        return new ResponseEntity<ArrayList<AndroidCategoryDto>>(categoriesService.getAllCategories(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public AndroidCategoryDto getCategoryById(@PathVariable Long id) {
        return categoriesService.getCategoryById(id);
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoriesService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategory(id);
    }
}
