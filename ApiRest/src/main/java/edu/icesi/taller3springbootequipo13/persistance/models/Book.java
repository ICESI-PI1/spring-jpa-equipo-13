package edu.icesi.taller3springbootequipo13.persistance.models;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private Date publicationDate;
    @ManyToOne
    @JoinColumn(name = "author_id") // Specify the foreign key column
    private Author author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book (){

    }

    public Book(Book book){
        this.title= book.getTitle();
        this.publicationDate = book.getPublicationDate();
        this.author = book.getAuthor();
    }
    public Book(String title, Date publicationDate, Author author){
        this.title = title;
        this.publicationDate = publicationDate;
        this.author = author;
    }
}
