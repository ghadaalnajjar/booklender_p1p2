package se.lexicon.alnajjar.booklender.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {

    Loan testObject;

    LibraryUser libraryUser;
    Book book;

    @BeforeEach
    public void setUp() {

        libraryUser = new LibraryUser(1, LocalDate.now(), "Maha", "m@yahoo.com");
        book = new Book(1, "Hello Pippi", true, true, 30, BigDecimal.valueOf(222.344), "good");

        testObject = new Loan(100, libraryUser, book, LocalDate.now(), false);
    }

    @Test
    public void test_create() {
        assertEquals(100, testObject.getLoanId());
        assertEquals(libraryUser, testObject.getLoanTaker());
        assertEquals(book, testObject.getBook());
        assertEquals(LocalDate.now(), testObject.getLoanDate());
        assertEquals(false, testObject.isTerminate());
    }

    @Test
    public void test_equal() {
        Loan isEqual = new Loan(100,libraryUser, book, LocalDate.now(), false);
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_hashCode() {
        Loan expected = new Loan(100, libraryUser, book, LocalDate.now(),false);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("100"));
        assertTrue(toString.contains(LocalDate.now().toString()));
        assertFalse(toString.contains("false"));
    }
}
