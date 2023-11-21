package edu.icesi.taller3springbootequipo13.service.impl;

import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IAuthorsRepository;
import edu.icesi.taller3springbootequipo13.persistance.respositories.IBooksRepository;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class BooksServiceImpl implements IBooksService {

    @Autowired
    private IBooksRepository booksRepository;

    @Autowired
    private IAuthorsRepository authorsRepository;


    @Override
    public Optional<Book> save(String title, Date publicationDate, Long id) {
        Iterable<Author> a= authorsRepository.findAll();
        Author b= null;
        for(Author author: a){
            if(author.getId()==id) {
                b = author;
                break;
            }
        }
        Book book= new Book(title,publicationDate,b);
        return Optional.of(booksRepository.save(book));
    }

    @Override
    public Author bk(Long id) {
        Iterable<Author> a= authorsRepository.findAll();
        Author b= null;
        for(Author author: a){
            if(author.getId()==id) {
                b = author;
                break;
            }
        }

        return b;
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
            Author author = book.getAuthor();
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
    public Optional<Author> findAuthorsByNationality(String nationality) {
        return authorsRepository.findByNationality(nationality);
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
    public List<Book> findBooksByAuthor(String name) {

        Iterable<Book> books = booksRepository.findAll();
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getAuthor().getName(), name)) {
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
    }
}
