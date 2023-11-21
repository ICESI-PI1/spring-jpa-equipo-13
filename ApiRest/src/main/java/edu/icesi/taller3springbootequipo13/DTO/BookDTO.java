package edu.icesi.taller3springbootequipo13.DTO;
import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private Date publicationDate;
    private Long authorId;
}
