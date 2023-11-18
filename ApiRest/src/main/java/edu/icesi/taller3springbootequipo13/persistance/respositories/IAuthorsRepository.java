package edu.icesi.taller3springbootequipo13.persistance.respositories;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IAuthorsRepository {
    Optional<Author> save(Author author);
    Optional<Author> findById(Long id);
    Optional<Author> delete(Long id);
    List<Author> getAll();
}
