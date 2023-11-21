package edu.icesi.taller3springbootequipo13.Mapper;

import edu.icesi.taller3springbootequipo13.DTO.AuthorDTO;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
public class AuthorMapper {

    public AuthorDTO authorToDto(Author author){
        Long id = author.getId();
        String name = author.getName();
        String nationality = author.getNationality();

        return new AuthorDTO(id, name, nationality);
    }

    public Author toAuthor(AuthorDTO dto){
        return new Author(dto.getId(), dto.getName(), dto.getNationality());
    }
}
