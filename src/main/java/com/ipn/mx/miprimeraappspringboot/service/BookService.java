package com.ipn.mx.miprimeraappspringboot.service;

import com.ipn.mx.miprimeraappspringboot.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book update(Integer id, Book book);
    List<Book> findAll();
    Book findById(Integer id);
    void delete(Integer id);


}
