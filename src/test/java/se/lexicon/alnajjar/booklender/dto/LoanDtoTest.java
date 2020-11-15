package se.lexicon.alnajjar.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LoanDtoTest {

    private LoanDto testObject;
    private LibraryUserDto testLibraryUser;
    private BookDto testBook;

    @BeforeEach
    void setUp() {
        testLibraryUser = new LibraryUserDto();
        testBook = new BookDto();
        testObject = new LoanDto();

        testObject.setLoanId(10);
        testObject.setLoanDate(LocalDate.now());
        testObject.setTerminate(false);
    }

    @Test
    public void default_Test() {
        assertEquals(10, testObject.getLoanId());
        assertNull(testObject.getLoanTaker());
        assertNull(testObject.getBook());
        assertEquals(LocalDate.now(), testObject.getLoanDate());
        assertFalse(testObject.isTerminate());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains(String.valueOf(testObject.getLoanId())));
        assertTrue(toString.contains(LocalDate.now().toString()));
        assertFalse(toString.contains("terminated=true"));
    }
}
