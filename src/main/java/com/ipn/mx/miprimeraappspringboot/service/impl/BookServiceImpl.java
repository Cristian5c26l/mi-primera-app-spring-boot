package com.ipn.mx.miprimeraappspringboot.service.impl;

import com.ipn.mx.miprimeraappspringboot.model.Book;
import com.ipn.mx.miprimeraappspringboot.repository.BookRepo;
import com.ipn.mx.miprimeraappspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo repo;

    @Override
    public Book save(Book book) {
        return this.repo.save(book);
    }

    @Override
    public Book update(Integer id, Book book) {
        book.setIdBook(id);// ???
        return this.repo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return this.repo.findById(id).orElse(new Book(-1, "NONE", false));
    }

    @Override
    public void delete(Integer id) {
        this.repo.deleteById(id);
    }

    /*public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }*/


}
