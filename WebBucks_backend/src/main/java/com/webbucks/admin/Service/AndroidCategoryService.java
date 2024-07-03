package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.Category;

public interface AndroidCategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
