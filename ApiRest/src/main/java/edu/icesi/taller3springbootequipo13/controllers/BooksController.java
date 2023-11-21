package edu.icesi.taller3springbootequipo13.controllers;

import edu.icesi.taller3springbootequipo13.DTO.BookDTO;
import edu.icesi.taller3springbootequipo13.Mapper.BookMapper;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/libros")
public class BooksController {

    private IBooksService service;

    @Autowired
    private BookMapper mapper;

    public BooksController (IBooksService booksService){
        this.service= booksService;
    }

    @GetMapping("")
    public List<BookDTO> getAll(){
        List<Book> books = (List<Book>) service.getAll();
        List<BookDTO> dtos = new ArrayList<>();
        for(Book b: books){
            dtos.add(mapper.bookToDto(b, b.getId()));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public BookDTO findOne(@PathVariable Long id){
        return mapper.bookToDto(service.findById(id).orElse(null), id);
    }


    @PostMapping("")
    public BookDTO create(@RequestBody BookDTO book){
        if(!this.service.findById(mapper.toBook(book).getId()).isPresent()) {
            Book a= mapper.toBook(book);
            System.out.println("este es el author: "+ book.getAuthorId());
            this.service.save(a.getTitle(), a.getPublicationDate(), book.getAuthorId()).orElse(null);
            return mapper.bookToDto(a, book.getAuthorId());
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Entity already in the program"
        );
    }

    @PutMapping("/{id}")
    public BookDTO changeBook(@PathVariable Long id, @RequestBody BookDTO book){
        Book book1= null;
        if(this.service.findById(id).isPresent()){
            Book a = mapper.toBook(book);
            book1 = this.service.edit(id,a).orElse(null);

        }
        return mapper.bookToDto(book1, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
       service.delete(id);
    }



}
