package com.ipn.mx.miprimeraappspringboot.service.impl;

import com.ipn.mx.miprimeraappspringboot.model.Book;
import com.ipn.mx.miprimeraappspringboot.repository.BookRepo;
import com.ipn.mx.miprimeraappspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo repo;

    /*public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }*/

    @Override
    public Book validAndReturn(int id) {
        if(id > 0) {// Logica de negocio
            return this.repo.getBookById(id);//Comunicarme con la capa de repositorio
        } else {
            return new Book(0, "NO TITLE", true);
        }
    }
}
