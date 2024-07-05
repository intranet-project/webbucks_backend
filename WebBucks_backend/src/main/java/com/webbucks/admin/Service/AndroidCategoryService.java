package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.Entity.Category;
import com.webbucks.admin.dto.AndroidCategoryDto;

public interface AndroidCategoryService {
    ArrayList<AndroidCategoryDto> getAllCategories();
    AndroidCategoryDto getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
