package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact("1", contact);
        assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact("1", contact);
        contactService.deleteContact("1");
        assertNull(contactService.getContact("1"));
    }

    @Test
    void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact("1", contact);
        contactService.updateContact("1", "Jane", "Doe", null, "456 Main St");
        Contact updatedContact = contactService.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("456 Main St", updatedContact.getAddress());
    }
}
