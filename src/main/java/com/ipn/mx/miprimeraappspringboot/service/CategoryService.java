package com.ipn.mx.miprimeraappspringboot.service;

import com.ipn.mx.miprimeraappspringboot.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category update(Integer id, Category category);
    List<Category> findAll();
    Category findById(Integer id);
    void delete(Integer id);


}
