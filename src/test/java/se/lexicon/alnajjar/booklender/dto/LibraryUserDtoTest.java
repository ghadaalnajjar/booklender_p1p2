package se.lexicon.alnajjar.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryUserDtoTest {

    private LibraryUserDto testObject;

    @BeforeEach
    public void setup() {
        testObject = new LibraryUserDto(11, LocalDate.now(), "Maha", "t@yahoo.com");
    }

    @Test
    public void default_Test() {
        assertEquals(11, testObject.getUserId());
        assertEquals(LocalDate.now(), testObject.getRegDate());
        assertEquals("Maha", testObject.getName());
        assertEquals("t@yahoo.com", testObject.getEmail());
    }

    @Test
    public void test_toString() {
        String toString = testObject.toString();
        assertTrue(toString.contains(String.valueOf(testObject.getUserId())));
        assertTrue(toString.contains(testObject.getRegDate().toString()));
        assertTrue(toString.contains(testObject.getName()));
        assertTrue(toString.contains(testObject.getEmail()));
    }
}
