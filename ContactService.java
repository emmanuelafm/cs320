package main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Map to store contacts by ID
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a new contact with a unique ID
    public void addContact(String id, Contact contact) {
        if (!contacts.containsKey(id)) {
            contacts.put(id, contact);
        } else {
            System.out.println("Contact with ID " + id + " already exists.");
        }
    }

    // Delete a contact by ID
    public void deleteContact(String id) {
        if (contacts.containsKey(id)) {
            contacts.remove(id);
        } else {
            System.out.println("Contact with ID " + id + " does not exist.");
        }
    }

    // Update contact fields by ID
    public void updateContact(String id, String firstName, String lastName, String number, String address) {
        if (contacts.containsKey(id)) {
            Contact contact = contacts.get(id);
            if (firstName != null) {
                contact.setFirstName(firstName);
            }
            if (lastName != null) {
                contact.setLastName(lastName);
            }
            if (number != null) {
                contact.setPhone(number);
            }
            if (address != null) {
                contact.setAddress(address);
            }
        } else {
            System.out.println("Contact with ID " + id + " does not exist.");
        }
    }
    
	public Contact getContact(String id) {
        if (contacts.containsKey(id)) {
        	return contacts.get(id);
        } else {
            System.out.println("Contact with ID " + id + " does not exist.");
          	return null;
        }
    }
}
