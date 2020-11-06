package se.lexicon.alnajjar.booklender.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.alnajjar.booklender.entity.Book;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired

    private BookRepository testObject;

    Book book;


    @BeforeEach
    public void setUp() {
        book = testObject.save(new Book("Hello Pippi",30, BigDecimal.valueOf(222.344),"good"));
    }

    @Test
    public void find_By_Reserved() {
        List<Book> findByReserved = testObject.findByReserved(false);
        System.out.println("findByReserved = " + findByReserved);
        assertEquals(false, book.isReserved());
    }

    @Test
    public void find_By_Available() {
        List<Book> findByAvailable = testObject.findByAvailable(false);
        System.out.println("findByAvailable = " + findByAvailable);
        assertEquals(false, book.isAvailable());
    }

    @Test
    public void test_find_By_Title() {
        List<Book> findByTitle = testObject.findByTitle("Hello Pippi");
        System.out.println("findByTitle = " + findByTitle);
        assertEquals("Hello Pippi", book.getTitle());
    }
}
