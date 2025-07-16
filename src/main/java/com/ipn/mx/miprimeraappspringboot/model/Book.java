package com.ipn.mx.miprimeraappspringboot.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int idBook;

    @Column(name = "book, title", length = 50,nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean enabled;


}
