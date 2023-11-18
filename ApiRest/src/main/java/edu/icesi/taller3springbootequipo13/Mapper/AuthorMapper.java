package edu.icesi.taller3springbootequipo13.Mapper;

import edu.icesi.taller3springbootequipo13.DTO.AuthorDTO;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDTO authorToDto(Author author){
        String name = author.getName();
        String nationality = author.getNationality();

        return new AuthorDTO(name, nationality);
    }

    public Author toAuthor(AuthorDTO dto){
        return new Author(dto.getName(), dto.getNationality());
    }
}
