package com.ipn.mx.miprimeraappspringboot.repository;

import com.ipn.mx.miprimeraappspringboot.model.Book;

public interface BookRepo {

    Book getBookById(int id);

}
