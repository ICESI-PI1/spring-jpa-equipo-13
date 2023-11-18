package edu.icesi.taller3springbootequipo13.persistance.respositories;

import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.impl.AuthorNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IBooksRepository {
    Optional<Book> save(Book book);
    Optional<Book> findById(Long id);
    Optional<Book> delete(Long id);
    List<Book> getAll();
    Optional<Book> edit(Long id, Book book);
    List<Book> findBooksByAuthor(Long id);
}
