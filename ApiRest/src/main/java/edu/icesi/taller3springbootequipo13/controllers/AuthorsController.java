package edu.icesi.taller3springbootequipo13.controllers;

import edu.icesi.taller3springbootequipo13.DTO.AuthorDTO;
import edu.icesi.taller3springbootequipo13.Mapper.AuthorMapper;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.IAuthorsService;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import edu.icesi.taller3springbootequipo13.service.impl.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/autores")

public class AuthorsController {

    @Autowired
    private IAuthorsService authorsService;


    private AuthorMapper mapper;

    public AuthorsController(){
        this.mapper= new AuthorMapper();
    }


    @Autowired
    private IBooksService booksService;

    @GetMapping("")
    public List<AuthorDTO> getallAuthors() {
        List<Author> authors = (List<Author>) authorsService.getAll();
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for(Author a: authors){
            authorDTOS.add(mapper.authorToDto(a));
        }
        return authorDTOS;
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable Long id) {
        return mapper.authorToDto(authorsService.findById(id).orElse(null));
    }

    @PostMapping("")
    public AuthorDTO newAuthor(@RequestBody AuthorDTO author) {
        System.out.println(author);
        Author a = mapper.toAuthor(author);
        System.out.println(a);
        this.authorsService.save(a).orElse(null);
        return mapper.authorToDto(a);
    }

    @PutMapping("/{id}")
    public AuthorDTO editAuthor(@PathVariable Long id, @RequestBody AuthorDTO author) throws AuthorNotFoundException {
        Author a = mapper.toAuthor(author);
        Author author1= this.authorsService.edit(id,a);
        return mapper.authorToDto(author1);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
       authorsService.delete(id);
    }

    @GetMapping("/{id}/libros")
    public List<Book> booksByAuthor(@PathVariable String id) {
        return booksService.findBooksByAuthor(id);
    }

}
