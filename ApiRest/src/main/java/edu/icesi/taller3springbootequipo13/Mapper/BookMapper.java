package edu.icesi.taller3springbootequipo13.Mapper;

import edu.icesi.taller3springbootequipo13.DTO.BookDTO;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDTO bookToDto (Book book){
        return  new BookDTO(book.getTitle(), book.getPublicationDate(), book.getAuthor());
    }

    public Book toBook(BookDTO dto){
        return new Book(dto.getTitle(), dto.getPublicationDate(), dto.getAuthor());
    }
}
