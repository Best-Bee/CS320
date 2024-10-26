package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
    }

    @Test
    public void testAddDuplicateContactId() {
        Contact contact1 = new Contact("John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertFalse(service.addContact(contact2));  // Should fail as contact ID is duplicate
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.deleteContact(contact.getContactId()));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.updateFirstName(contact.getContactId(), "Jane"));
        assertEquals("Jane", service.getContact(contact.getContactId()).getFirstName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.updatePhone(contact.getContactId(), "0987654321"));
        assertEquals("0987654321", service.getContact(contact.getContactId()).getPhone());
    }
}