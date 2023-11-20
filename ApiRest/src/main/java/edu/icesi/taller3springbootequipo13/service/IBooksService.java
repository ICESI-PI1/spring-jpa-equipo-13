package edu.icesi.taller3springbootequipo13.service;
import java.util.List;
import java.util.Optional;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;

public interface IBooksService {

    Optional<Book> save(Book book);
    Iterable<Book> getAll();
    Optional<Book> edit(Long id, Book book);
    Optional<Book> findById(Long id);
    void delete(Long id);
    List<Book> findBooksByAuthor(Long id);
}
