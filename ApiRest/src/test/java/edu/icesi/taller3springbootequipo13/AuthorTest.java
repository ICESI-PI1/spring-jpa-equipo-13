package edu.icesi.taller3springbootequipo13;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import edu.icesi.taller3springbootequipo13.persistance.models.Author;
import edu.icesi.taller3springbootequipo13.service.IAuthorsService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional

public class AuthorTest {


    @Autowired
    private IAuthorsService authorsService;
    private Author author;

    public AuthorTest() {
        this.authorsService = null;
    }



    public void setupInitial(){
        author= null;
    }

    @Test
    public void setUpPost(){
        author = new Author("@JuanJoDays", "American");
        Optional<Author> savedAuthor = authorsService.save(author);

        assertTrue(savedAuthor.isPresent());
        assertEquals("@JuanJoDays", savedAuthor.get().getName());
        assertEquals("American", savedAuthor.get().getNationality());
        assertNotNull(savedAuthor.get().getId());
    }


}
*/