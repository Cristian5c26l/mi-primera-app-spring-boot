package com.ipn.mx.miprimeraappspringboot.controller;

import com.ipn.mx.miprimeraappspringboot.model.Category;
import com.ipn.mx.miprimeraappspringboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;// instancia inyectada que es un bean

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = this.categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = this.categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category createdCategory = this.categoryService.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable("id") Integer id, @RequestBody Category category) {
        Category updatedCategory = this.categoryService.update(id, category);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable("id") Integer id) {
        this.categoryService.delete(id);

        return ResponseEntity.noContent().build();// Responder a la petición sin nada de contenido. Con build se indica que ya se terminó la petición
    }
}
