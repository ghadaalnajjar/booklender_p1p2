package se.lexicon.alnajjar.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BookDtoTest {

    private BookDto testObject;

    @BeforeEach
    public void setup() {
        testObject = new BookDto();

        testObject.setBookId(12);
        testObject.setTitle("Hello Pippi");
        testObject.setAvailable(true);
        testObject.setReserved(true);
        testObject.setMaxLoansDays(30);
        testObject.setFinePerDay(BigDecimal.valueOf(22.2));
        testObject.setDescription("good");
    }

    @Test
    public void default_Test() {
        assertEquals(12, testObject.getBookId());
        assertEquals("Hello Pippi", testObject.getTitle());
        assertTrue(testObject.isAvailable());
        assertTrue(testObject.isReserved());
        assertEquals(30, testObject.getMaxLoansDays());
        assertEquals(BigDecimal.valueOf(22.2), testObject.getFinePerDay());
        assertEquals("good", testObject.getDescription());
    }

    @Test
    public void toString_Test() {
        String toString = testObject.toString();
        assertTrue(toString.contains(String.valueOf(testObject.getBookId())));
        assertTrue(toString.contains(testObject.getTitle()));
        System.out.println("Title" +testObject);
        assertTrue(toString.contains("available=true"));
        assertTrue(toString.contains("reserved=true"));
        assertTrue(toString.contains(testObject.getFinePerDay().toString()));
        assertTrue(toString.contains(testObject.getDescription()));
    }
}
