package edu.icesi.taller3springbootequipo13.service.impl;

import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IAuthorsRepository;
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

    @Autowired
    private IAuthorsRepository authorsRepository;


    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(booksRepository.save(book));
    }

    @Override
    public Iterable<Book> getAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        if(booksRepository.findById(id).isPresent()){
            return Optional.empty();
        }else{
            Author author = authorsRepository.findById(book.getAuthorId()).orElse(null);
            if(author==null) {
                return Optional.empty();
            } else {
                delete(id);
                booksRepository.save(book);
                return Optional.of(book);
            }
        }


    }

    @Override
    public Optional<Book> findById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        booksRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByAuthor(Long id) {

        Iterable<Book> books = booksRepository.findAll();
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getAuthorId(), id)) {
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
    }
}
