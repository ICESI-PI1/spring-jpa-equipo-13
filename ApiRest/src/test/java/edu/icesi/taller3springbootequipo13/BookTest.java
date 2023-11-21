package edu.icesi.taller3springbootequipo13;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IAuthorsRepository;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IBooksRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookTest {

    @Autowired
    private IBooksRepository bookRepository;

    @Autowired
    private IAuthorsRepository authorRepository;

    @AfterEach
    public void cleanUp() {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    public void testSaveBook() {
        // Given
        Author author = new Author("John Doe", "American");
        authorRepository.save(author);

        Book book = new Book("Sample Book", new Date(), author);

        // When
        Book savedBook = bookRepository.save(book);

        // Then
        assertNotNull(savedBook.getId());
        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getPublicationDate(), savedBook.getPublicationDate());
        assertEquals(book.getAuthor(), savedBook.getAuthor());
    }

    @Test
    public void testFindBookById() {
        // Given
        Author author = new Author("Jane Doe", "British");
        authorRepository.save(author);

        Book book = new Book("Another Book", new Date(), author);
        Book savedBook = bookRepository.save(book);

        // When
        Optional<Book> foundBook = bookRepository.findById(savedBook.getId());

        // Then
        assertTrue(foundBook.isPresent());
        assertEquals(savedBook.getId(), foundBook.get().getId());
        assertEquals(savedBook.getTitle(), foundBook.get().getTitle());
        assertEquals(savedBook.getPublicationDate(), foundBook.get().getPublicationDate());
        assertEquals(savedBook.getAuthor(), foundBook.get().getAuthor());
    }

    @Test
    public void testUpdateBook() {
        // Given
        Author author = new Author("Jack Smith", "Canadian");
        authorRepository.save(author);

        Book book = new Book("Book to Update", new Date(), author);
        Book savedBook = bookRepository.save(book);

        // When
        savedBook.setTitle("Updated Book");
        savedBook.setPublicationDate(new Date());
        savedBook.setAuthor(authorRepository.findByNationality("Canadian").orElse(null));
        Book updatedBook = bookRepository.save(savedBook);

        // Then
        assertEquals(savedBook.getId(), updatedBook.getId());
        assertEquals("Updated Book", updatedBook.getTitle());
        assertEquals(savedBook.getPublicationDate(), updatedBook.getPublicationDate());
        assertEquals(savedBook.getAuthor(), updatedBook.getAuthor());
    }

    @Test
    public void testDeleteBook() {
        // Given
        Author author = new Author("Alex Brown", "Australian");
        authorRepository.save(author);

        Book book = new Book("Book to Delete", new Date(), author);
        Book savedBook = bookRepository.save(book);

        // When
        bookRepository.deleteById(savedBook.getId());

        // Then
        Optional<Book> deletedBook = bookRepository.findById(savedBook.getId());
        assertFalse(deletedBook.isPresent());
    }

    @Test
    public void testFindAllBooks() {
        // Given
        Author author = new Author("John Doe", "American");
        authorRepository.save(author);

        Book book1 = new Book("Book 1", new Date(), author);
        Book book2 = new Book("Book 2", new Date(), author);

        bookRepository.save(book1);
        bookRepository.save(book2);

        // When
        List<Book> books = convertIterableToList(bookRepository.findAll());

        // Then
        assertEquals(17, books.size()); //debido a que en los script hay cargados 15
    }

    private <T> List<T> convertIterableToList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}

