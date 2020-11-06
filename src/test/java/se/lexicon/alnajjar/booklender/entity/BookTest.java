package se.lexicon.alnajjar.booklender.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookTest {

    Book testObject;

    @BeforeEach
    public void setup() {
       testObject = new Book("Hello Pippi", 30, BigDecimal.valueOf(222.344), "good");
    }

    @Test
    public void test_create() {
        assertEquals("Hello Pippi", testObject.getTitle());
        assertEquals(30, testObject.getMaxLoansDays());
        assertEquals(BigDecimal.valueOf(222.344), testObject.getFinePerDay());
        assertEquals("good", testObject.getDescription());
    }

    @Test
    public void test_equal() {
        Book isEqual = new Book("Hello Pippi", 30, BigDecimal.valueOf(222.344), "good");
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_hashCode() {
        Book expected = new Book("Hello Pippi",30, BigDecimal.valueOf(222.344), "good");
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("Hello Pippi"));
        assertTrue(toString.contains("30"));
        assertTrue(toString.contains("good"));
    }
}
