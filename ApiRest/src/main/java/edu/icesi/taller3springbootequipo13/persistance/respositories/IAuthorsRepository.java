package edu.icesi.taller3springbootequipo13.persistance.respositories;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorsRepository extends CrudRepository<Author, Long> {
    //List<Author> getAll();

    //Optional<Author> delete(Long id);

    @Override
    <S extends Author> S save(S s);

    Optional<Author> findByNationality(String nationality);
}
