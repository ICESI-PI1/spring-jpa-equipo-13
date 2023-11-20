package edu.icesi.taller3springbootequipo13.persistance.models;


import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String nationality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Author(){

    }

    public Author(Author author) {
        this.name = author.getName();
        this.nationality = author.getNationality();
    }

    public Author(String name, String nationality){
        this.name= name;
        this.nationality = nationality;
    }
}
