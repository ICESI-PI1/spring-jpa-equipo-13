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
    private Long authorId;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Book (){

    }

    public Book(Book book){
        this.title= book.getTitle();
        this.publicationDate = book.getPublicationDate();
        this.authorId = book.getAuthorId();
    }
    public Book(String title, Date publicationDate, Long authorId){
        this.title = title;
        this.publicationDate = publicationDate;
        this.authorId = authorId;
    }
}
