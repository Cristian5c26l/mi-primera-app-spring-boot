package com.ipn.mx.miprimeraappspringboot.controller;

import com.ipn.mx.miprimeraappspringboot.model.Book;
import com.ipn.mx.miprimeraappspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = this.bookService.findAll();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
        Book book = this.bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book createdBook = this.bookService.save(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Integer id, @RequestBody Book book) {
        Book updatedBook = this.bookService.update(id, book);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable("id") Integer id) {
        this.bookService.delete(id);

        return ResponseEntity.noContent().build();// Responder a la petición sin nada de contenido. Con build se indica que ya se terminó la petición
    }
}
