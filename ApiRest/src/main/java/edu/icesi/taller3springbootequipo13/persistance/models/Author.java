package edu.icesi.taller3springbootequipo13.persistance.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String nationality;

    public Author(){

    }

    public Author(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.nationality = author.getNationality();
    }
}
