package com.ipn.mx.miprimeraappspringboot.repository;

import com.ipn.mx.miprimeraappspringboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> { }// Gracias a que CategoryRepo extiende de JpaRepository, ya no es necesaria colocar la notacion @Repository, pues se la coloca implicitamente. Recordar que dicha notacion hace que se cree una instancia tipo "bean" (singleton) de CategoryRepo. Ademas, habilita que dicha instancia se pueda inyectar como dependencia a otras clases
