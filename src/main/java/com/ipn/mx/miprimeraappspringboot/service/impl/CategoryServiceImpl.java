package com.ipn.mx.miprimeraappspringboot.service.impl;
import com.ipn.mx.miprimeraappspringboot.model.Category;
import com.ipn.mx.miprimeraappspringboot.repository.CategoryRepo;
import com.ipn.mx.miprimeraappspringboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo repo;

    @Override
    public Category save(Category category) {
        return this.repo.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        category.setIdCategory(id);
        return this.repo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return this.repo.findById(id).orElse(new Category(-1, "NONE"));
    }

    @Override
    public void delete(Integer id) {
        this.repo.deleteById(id);
    }

    /*public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }*/


}
