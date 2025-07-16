package com.ipn.mx.miprimeraappspringboot.repository;

import com.ipn.mx.miprimeraappspringboot.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepoImpl implements BookRepo {
    @Override
    public Book getBookById(int id) {
        return new Book(1, "1998 - El Cálculo - Leithold", true);
    }
}
