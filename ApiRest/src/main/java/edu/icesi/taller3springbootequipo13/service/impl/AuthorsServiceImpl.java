package edu.icesi.taller3springbootequipo13.service.impl;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IAuthorsRepository;
import edu.icesi.taller3springbootequipo13.service.IAuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorsServiceImpl implements IAuthorsService {

    @Autowired
    private IAuthorsRepository authorsRepository;


    @Override
    public Optional<Author> save(Author author) {
        try {
            return Optional.of(authorsRepository.save(author));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Iterable<Author> getAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Author edit(Long id, Author newAuthor) throws AuthorNotFoundException {
        authorsRepository.deleteById(newAuthor.getId());
        return authorsRepository.save(newAuthor);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorsRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        authorsRepository.deleteById(id);
    }


}
