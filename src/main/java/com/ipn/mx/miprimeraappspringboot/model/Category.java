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
public class Category {

    @Id
    private Integer idCategory;// a nivel de tabla category en la bd postgres, esta columna se llamará "

    @Column(length = 50, nullable = false)
    private String name;


}
