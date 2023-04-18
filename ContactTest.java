package main;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact;

    @Before
    public void setUp() {
        contact = new Contact("C123456789", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testValidContact() {
        assertEquals("C123456789", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact("C1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        new Contact("C123456789", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        new Contact("C123456789", "John", "DoeDoeDoe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhone() {
        new Contact("C123456789", "John", "Doe", "123456789", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        new Contact("C123456789", "John", "Doe", "1234567890", "1234567890123456789012345678901");
    }

    @Test(expected = NullPointerException.class)
    public void testNullFirstName() {
        new Contact("C123456789", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = NullPointerException.class)
    public void testNullLastName() {
        new Contact("C123456789", "John", null, "1234567890", "123 Main St");
    }

    @Test(expected = NullPointerException.class)
    public void testNullPhone() {
        new Contact("C123456789", "John", "Doe", null, "123 Main St");
    }

    @Test(expected = NullPointerException.class)
    public void testNullAddress() {
        new Contact("C123456789", "John", "Doe", "1234567890", null);
    }

}
