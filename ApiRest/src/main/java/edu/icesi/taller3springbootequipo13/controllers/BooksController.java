package edu.icesi.taller3springbootequipo13.controllers;

import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/libros")
public class BooksController {

    private IBooksService service;

    public BooksController (IBooksService booksService){
        this.service= booksService;
    }

    @GetMapping("")
    public List<Book> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id){
        return service.findById(id).orElse(null);
    }


    @PostMapping("")
    public Optional<Book> create(@RequestBody Book book){
        if(!this.service.findById(book.getId()).isPresent())
            return this.service.save(book);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Entity already in the program"
        );
    }

    @PutMapping("/{id}")
    public Book changeBook(@PathVariable Long id, @RequestBody Book book){
        if(this.service.findById(id).isPresent()){
            this.service.edit(id,book);
        }
        return book;
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable Long id){
        return service.delete(id).orElse(null);
    }



}
