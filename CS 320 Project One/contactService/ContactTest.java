package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactCreationInvalidId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "Doe", "1234567890", "123 Main St");
        });
        assertNotNull(exception);
    }

    @Test
    public void testContactCreationInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Johnnnnnnnnn", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name.", exception.getMessage());
    }
}