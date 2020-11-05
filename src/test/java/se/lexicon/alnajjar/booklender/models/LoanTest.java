package se.lexicon.alnajjar.booklender.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoanTest {

    Loan testObject;

    long loanId;
    private LibraryUser loanTaker;
    private Book book;
    private LocalDate loanDate;
    private boolean terminated;

    @BeforeEach
    public void setUp() {
        loanId = 111111;
        loanTaker = new LibraryUser ();
        book = new Book();
        terminated = true;

        testObject = new Loan(loanId, loanTaker, book, LocalDate.parse("2020-10-20"), terminated);
    }

    @Test
    public void test_create() {
        assertEquals(loanId, testObject.getLoanId());
        assertEquals(loanTaker, testObject.getLoanTaker());
        assertEquals(book, testObject.getBook());
        assertEquals(LocalDate.parse("2020-10-20"), testObject.getLoanDate());
        assertEquals(terminated, testObject.isTerminated());
    }

    @Test
    public void test_equal() {
        Loan isEqual = new Loan(loanId, loanTaker, book, LocalDate.parse("2020-10-20"), terminated);
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_hashCode() {
        Loan expected = new Loan(loanId, loanTaker, book, LocalDate.parse("2020-10-20"), terminated);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("1111"));
        assertTrue(toString.contains("2020-10-20"));
    }
}