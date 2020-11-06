package se.lexicon.alnajjar.booklender.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryUserTest {

    LibraryUser testObject;

    @BeforeEach
    public void setUp() {

        testObject = new LibraryUser (LocalDate.now(), "Maha", "m@yahoo.com");
    }

    @Test
    public void test_create() {
        assertEquals(LocalDate.now(), testObject.getRegDate());
        assertEquals("Maha", testObject.getName());
        assertEquals("m@yahoo.com", testObject.getEmail());
    }

    @Test
    public void test_equal() {
        LibraryUser isEqual = new LibraryUser(LocalDate.now(), "Maha", "m@yahoo.com");
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_hashCode() {
        LibraryUser expected = new LibraryUser(LocalDate.now(), "Maha", "m@yahoo.com");
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("Maha"));
        assertTrue(toString.contains("m@yahoo.com"));
    }
}
