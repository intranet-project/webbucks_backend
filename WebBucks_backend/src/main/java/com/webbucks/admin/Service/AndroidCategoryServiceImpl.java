package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Category;
import com.webbucks.Repository.CategoryRepository;
import com.webbucks.admin.dto.AndroidCategoryDto;

@Service
public class AndroidCategoryServiceImpl implements AndroidCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ArrayList<AndroidCategoryDto> getAllCategories() {
    	List<AndroidCategoryDto> categoryData = categoryRepository.findAll().stream()
				.map(category -> AndroidCategoryDto.builder()
						.category_id(category.getCategoryId())
						.category_name(category.getCategoryname()).build())
				.collect(Collectors.toList());
        return (ArrayList<AndroidCategoryDto>) categoryData;
    }

    @Override
    public AndroidCategoryDto getCategoryById(Long id) {
    	Category category = categoryRepository.findById(id).orElse(null);
    	AndroidCategoryDto categoryData = new AndroidCategoryDto();
    	categoryData.setCategory_id(category.getCategoryId());
    	categoryData.setCategory_name(category.getCategoryname());
        return categoryData;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
    	categoryRepository.deleteById(id);
    }
}
