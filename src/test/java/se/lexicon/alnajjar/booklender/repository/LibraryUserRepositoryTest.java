package se.lexicon.alnajjar.booklender.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.alnajjar.booklender.entity.Book;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class LibraryUserRepositoryTest {

    @Autowired

    private  LibraryUserRepository testObject;

    LibraryUser libraryUser;

   @BeforeEach
    public void setUp() {
        libraryUser = testObject.save(new LibraryUser(LocalDate.now(), "Maha", "m@yahoo.com"));
    }

    @Test
    public void test_find_By_Email() {
        List<LibraryUser> findByEmail = testObject.findByEmail("m@yahoo.com");
        System.out.println("findByEmail = " + findByEmail);
        assertEquals("m@yahoo.com", libraryUser.getEmail());
}
    }
