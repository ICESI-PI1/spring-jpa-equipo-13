package edu.icesi.taller3springbootequipo13.service.impl;

import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IBooksRepository;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BooksServiceImpl implements IBooksService {

    @Autowired
    private IBooksRepository booksRepository;

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(booksRepository.save(book));
    }

    @Override
    public List<Book> getAll() {
        return booksRepository.getAll();
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        return booksRepository.edit(id, book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Optional<Book> delete(Long id) {
        return booksRepository.delete(id);
    }

    @Override
    public List<Book> findBooksByAuthor(Long id) {

        List<Book> books = booksRepository.getAll();
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getAuthorId(), id)) {
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
    }
}
