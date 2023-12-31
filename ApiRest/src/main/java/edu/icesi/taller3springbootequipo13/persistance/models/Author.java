package edu.icesi.taller3springbootequipo13.persistance.models;


import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Set<Book> books;


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
        this.id= author.getId();
        this.name = author.getName();
        this.nationality = author.getNationality();
    }

    public Author(String name, String nationality){
        this.name= name;
        this.nationality = nationality;
    }

    public Author(Long id, String name, String nationality){
        this.id = id;
        this.name= name;
        this.nationality = nationality;
    }


}
