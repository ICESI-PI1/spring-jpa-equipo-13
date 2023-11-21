package edu.icesi.taller3springbootequipo13;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IAuthorsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
//Pregunta seria, como cancelo mi vida?
@DataJpaTest
public class AuthorTest {

    @Autowired
    private IAuthorsRepository authorRepository;

    @AfterEach
    public void cleanUp() {
        authorRepository.deleteAll();
    }

    @Test
    public void testSaveAuthor() {
        Author author = new Author("John Doe", "American");
        Author savedAuthor = authorRepository.save(author);

        assertNotNull(savedAuthor.getId());
        assertEquals(author.getName(), savedAuthor.getName());
        assertEquals(author.getNationality(), savedAuthor.getNationality());
    }

    @Test
    public void testFindAuthorById() {
        Author author = new Author("Jane Doe", "British");
        Author savedAuthor = authorRepository.save(author);

        Optional<Author> foundAuthor = authorRepository.findById(savedAuthor.getId());

        assertTrue(foundAuthor.isPresent());
        assertEquals(savedAuthor.getId(), foundAuthor.get().getId());
        assertEquals(savedAuthor.getName(), foundAuthor.get().getName());
        assertEquals(savedAuthor.getNationality(), foundAuthor.get().getNationality());
    }

    @Test
    public void testUpdateAuthor() {
        Author author = new Author("Jack Smith", "Canadian");
        Author savedAuthor = authorRepository.save(author);

        savedAuthor.setName("Updated Name");
        savedAuthor.setNationality("Updated Nationality");

        Author updatedAuthor = authorRepository.save(savedAuthor);

        assertEquals(savedAuthor.getId(), updatedAuthor.getId());
        assertEquals("Updated Name", updatedAuthor.getName());
        assertEquals("Updated Nationality", updatedAuthor.getNationality());
    }

    @Test
    public void testDeleteAuthor() {
        Author author = new Author("Alex Brown", "Australian");
        Author savedAuthor = authorRepository.save(author);

        authorRepository.deleteById(savedAuthor.getId());

        Optional<Author> deletedAuthor = authorRepository.findById(savedAuthor.getId());

        assertFalse(deletedAuthor.isPresent());
    }

    @Test
    public void testFindAllAuthors() {
        Author author1 = new Author("John Doe", "American");
        Author author2 = new Author("Jane Doe", "British");

        authorRepository.save(author1);
        authorRepository.save(author2);

        Iterable<Author> authorsIterable = authorRepository.findAll();
        List<Author> authors = convertIterableToList(authorsIterable);

        assertEquals(17, authors.size());//esto debido a que en el script habian 15 cargados
    }

    private <T> List<T> convertIterableToList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
