package com.ipn.mx.miprimeraappspringboot.repository;

import com.ipn.mx.miprimeraappspringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> { }// Gracias a que BookRepo extiende de JpaRepository, ya no es necesaria colocar la notacion @Repository, pues se la coloca explicitamente. Recordar que dicha notacion hace que se cree una instancia tipo "bean" (singleton) de BookRepo. Ademas, habilita que dicha instancia se pueda inyectar como dependencia a otras clases
