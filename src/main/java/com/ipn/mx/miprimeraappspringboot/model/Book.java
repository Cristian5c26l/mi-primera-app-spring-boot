package com.ipn.mx.miprimeraappspringboot.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JacksonXmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private Integer idBook;

    @Column(name = "book_title", length = 50,nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;// personalizar el nombre de la columna con la cual se va a relacionar las tablas. En este caso, realmente, la tabla book, en la base de datos postgres, va a tener una columna tipo int llamada "id_category" (en lugar de que se llame simplemente "category). Esta columna es una llave foranea, es decir, es una llave que viene de otra tabla, la cual es la tabla "category"

    @Column(nullable = false)
    private boolean enabled;


}
