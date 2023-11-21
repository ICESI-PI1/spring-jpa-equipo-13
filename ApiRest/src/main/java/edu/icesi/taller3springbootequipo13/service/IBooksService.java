package edu.icesi.taller3springbootequipo13.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;

public interface IBooksService {

    Optional<Book> save(String title, Date publicationDate, Long id);
    Iterable<Book> getAll();
    Optional<Book> edit(Long id, Book book);
    Optional<Book> findById(Long id);
    void delete(Long id);
    List<Book> findBooksByAuthor(String name);

    Author bk(Long id);
    Optional<Author> findAuthorsByNationality(String nationality);
}
