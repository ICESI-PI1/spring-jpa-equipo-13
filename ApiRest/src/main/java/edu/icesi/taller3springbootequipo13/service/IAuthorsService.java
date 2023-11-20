package edu.icesi.taller3springbootequipo13.service;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.service.impl.AuthorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IAuthorsService {
    Optional<Author> save(Author author);
    Iterable<Author> getAll();
    Author edit(Long id, Author author) throws AuthorNotFoundException;
    Optional<Author> findById(Long id);
    void delete(Long id);
}
