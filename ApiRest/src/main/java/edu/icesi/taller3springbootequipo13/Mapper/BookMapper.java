package edu.icesi.taller3springbootequipo13.Mapper;

import edu.icesi.taller3springbootequipo13.DTO.BookDTO;
import edu.icesi.taller3springbootequipo13.persistance.models.Book;
import edu.icesi.taller3springbootequipo13.service.IAuthorsService;
import edu.icesi.taller3springbootequipo13.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    @Autowired
    private IBooksService booksService;
    public BookDTO bookToDto (Book book, Long id){
        return  new BookDTO(book.getTitle(), book.getPublicationDate(), id);
    }

    public Book toBook(BookDTO dto){
        return new Book(dto.getTitle(), dto.getPublicationDate(), booksService.bk(dto.getAuthorId()));
    }
}
