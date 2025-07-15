package com.ipn.mx.miprimeraappspringboot.controller;

import com.ipn.mx.miprimeraappspringboot.model.Book;
import com.ipn.mx.miprimeraappspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;// instancia inyectada que es un bean
    //private String text;

    /*public BookController(BookService bookService) {
        this.bookService = bookService;
    }*/

    @GetMapping
    public Book getBook() {
        //return new Book(1, "1998 - El Cálculo - Leithold");
        return this.bookService.validAndReturn(0);
    }
}
