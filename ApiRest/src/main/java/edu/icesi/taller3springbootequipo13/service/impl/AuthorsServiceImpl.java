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
        return Optional.of(authorsRepository.save(author));
    }

    @Override
    public Iterable<Author> getAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Author edit(Long id, Author newAuthor) throws AuthorNotFoundException {
        Iterable<Author> authors = authorsRepository.findAll();
        /*
        for(int i=0; i<authors.size(); i++){
            if(Objects.equals(authors.get(i).getId(), id)){
                Author author = authors.get(i);
                author.setName(newAuthor.getName());
                author.setNationality(newAuthor.getNationality());
                return author;
            }
        }
        */


        for(Author a: authors){
            if(Objects.equals(a.getId(), id)){
                Author author = a;
                author.setName(newAuthor.getName());
                author.setNationality(newAuthor.getNationality());
                return author;
            }
        }

        throw new AuthorNotFoundException("No se encontró un autor con el ID especificado: " + id);
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
