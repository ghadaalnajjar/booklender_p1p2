package se.lexicon.alnajjar.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookDtoTest {

    private BookDto testObject;


    @BeforeEach
    public void setup() {
        testObject = new BookDto(12, "Hello Pippi", 30,   "good");
    }

    @Test
    public void default_Test() {
        assertEquals(12, testObject.getBookId());
        assertEquals("Hello Pippi", testObject.getTitle());
        assertFalse(testObject.isAvailable());
        assertFalse(testObject.isReserved());
        assertEquals(30, testObject.getMaxLoansDays());
        assertEquals("good", testObject.getDescription());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains(String.valueOf(testObject.getBookId())));
        assertTrue(toString.contains(testObject.getTitle()));
        assertTrue(toString.contains("available=false"));
        assertTrue(toString.contains("reserved=false"));
        assertTrue(toString.contains(Integer.toString(testObject.getMaxLoansDays())));
        assertTrue(toString.contains(testObject.getDescription()));
    }

}
