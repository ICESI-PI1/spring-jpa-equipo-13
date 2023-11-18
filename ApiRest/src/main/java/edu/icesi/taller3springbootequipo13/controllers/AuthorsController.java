package edu.icesi.taller3springbootequipo13.controllers;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.IAuthorsService;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import edu.icesi.taller3springbootequipo13.service.impl.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/autores")

public class AuthorsController {

    @Autowired
    private IAuthorsService authorsService;

    @Autowired
    private IBooksService booksService;

    @GetMapping("")
    public List<Author> getallAuthors() {
        return authorsService.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorsService.findById(id).orElse(null);
    }

    @PostMapping("")
    public Optional<Author> newAuthor(@RequestBody Author author) {
        System.out.println(author);
        return authorsService.save(author);
    }

    @PutMapping("/{id}")
    public Author editAuthor(@PathVariable Long id, @RequestBody Author author) throws AuthorNotFoundException {
        return authorsService.edit(id, author);
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable Long id) {
        return authorsService.delete(id).orElse(null);
    }

    @GetMapping("/{id}/libros")
    public List<Book> booksByAuthor(@PathVariable Long id) {
        return booksService.findBooksByAuthor(id);
    }

}
