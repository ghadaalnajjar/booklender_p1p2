package se.lexicon.alnajjar.booklender.service;

import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.alnajjar.booklender.dto.BookDto;
import se.lexicon.alnajjar.booklender.entity.Book;
import se.lexicon.alnajjar.booklender.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceUnitTest {

    @Autowired

    private BookRepository bookRepository;

    private BookDto bookDto;

    private ModelMapper mapper = new ModelMapper();

    private Book book = new Book();

    @Test
    public void create() {
        book.setTitle("Hello Pippi");
        book.setMaxLoansDays(30);
        book.setAvailable(false);
        book.setReserved(false);
        book.setDescription("good");

        BookDto bookDto = mapper.map(book, BookDto.class);

        assertEquals(book.getTitle(), bookDto.getTitle());
        assertEquals(book.isAvailable(), bookDto.isAvailable());
        assertEquals(book.isReserved(), bookDto.isReserved());
        assertEquals(book.getDescription(), bookDto.getDescription());
    }

    @Test
    public void findById() {
        bookDto = mapper.map(book, BookDto.class);
        assertEquals(bookDto.getBookId(), book.getBookId());
    }

    @Test
    public void findByTitle() {
        book.setTitle("Hello Pippi");
        bookDto = mapper.map(book, BookDto.class);
        assertEquals(bookDto.getTitle(), book.getTitle());
    }

    @Test
    public void findByReserved() {
        book.isReserved();
        bookDto = mapper.map(book, BookDto.class);
        assertEquals(bookDto.isReserved(), book.isReserved());
    }

    @Test
    public void findByAvailable() {
        book.isAvailable();
        bookDto = mapper.map(book, BookDto.class);
        assertEquals(bookDto.isAvailable(), book.isAvailable());
    }
}

