package edu.icesi.taller3springbootequipo13.persistance.respositories;

import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.impl.AuthorNotFoundException;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IBooksRepository extends CrudRepository<Book, Long> {


    List<Book> findBooksByAuthor(Long id);


}
