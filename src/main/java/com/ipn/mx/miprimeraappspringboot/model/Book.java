package com.ipn.mx.miprimeraappspringboot.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JacksonXmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int idBook;
    private String title;


}
