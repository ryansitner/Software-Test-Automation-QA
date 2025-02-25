/*
 * Developer: Ryan Sitner
 * Date: 1/23/2025
 */

package main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	boolean addSuccessful = false;
	
	// After each test, clear array list
	@AfterEach
	void tearDown() throws Exception {
		ContactService.contactList.clear();
	}
	
	// Create a contact and confirm the values are properly set
	@DisplayName("Test Create & Verify Contact")
	@ Test
	void testContactServiceCreate() {
		Contact c1 = new Contact("2001", "Ryan", "Johnson", "1234567890", "123 Make Believe");
		ContactService.contactList.add(c1);
		
		assertTrue(ContactService.contactList.get(0).getContactID().equals("2001"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("Ryan"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Johnson"));
		assertTrue(ContactService.contactList.get(0).getPhoneNumber().equals("1234567890"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("123 Make Believe"));
	}
	
	// Create contacts, delete one, confirm its deleted
		@DisplayName("Test Delete Contact")
		@Test
		void testDeleteContact() {
			boolean testDeletionFailed = false;
			
			Contact c1 = new Contact("2002", "Grog", "Strongjaw", "1000000009", "112 Bluff Point Road");
			Contact c2 = new Contact("2003", "Tim", "Robers", "8763210598", "1122 Dreams Blvd");
			Contact c3 = new Contact("2004", "Brian", "Poghes", "7412589633", "2 Smert Street");
			
			ContactService.contactList.add(c1);
			ContactService.contactList.add(c2);
			ContactService.contactList.add(c3);
			
			// Confirm all three contacts were added
			assertEquals(3, ContactService.contactList.size());
			
			ContactService.deleteContact("2003");
			
			// Confirm size of contactList changed to 2, and the contact was deleted
			assertEquals(2, ContactService.contactList.size());
			for (int i = 0; i < ContactService.contactList.size(); ++i) {
				if (ContactService.contactList.get(i).getContactID() == "2003") {
					testDeletionFailed = true;
				}
			}
			assertFalse(testDeletionFailed);
		}
	
		// Testing updateFirstName after contact creation
		@DisplayName("Change First Name")
		@Test
		void testChangeFirstName() {
			Contact c1 = new Contact("2005", "Bill", "Burrow", "7779642588", "23 Peel Drive");
			ContactService.contactList.add(c1);
			
			assertEquals("Bill", ContactService.contactList.get(0).getFirstName());
			
			ContactService.updateFirstName("2005", "Tony");
			assertEquals("Tony", ContactService.contactList.get(0).getFirstName());
		}
		
		// Testing updateLastName after contact creation
		@DisplayName("Change Last Name")
		@Test
		void testChangeLastName() {
			Contact c1 = new Contact("2006", "Sam", "Whick", "1598763548", "11 Sweet Pea Lane");
			ContactService.contactList.add(c1);
					
			assertEquals("Whick", ContactService.contactList.get(0).getLastName());
					
			ContactService.updateLastName("2006", "Smith");
			assertEquals("Smith", ContactService.contactList.get(0).getLastName());
		}
				
		// Testing updatePhoneNumber after contact creation
		@DisplayName("Change Phone Number")
		@Test
		void testChangePhoneNumber() {
			Contact c1 = new Contact("2007", "Ray", "Uzumaki", "1234567890", "7 Billiard Drive");
			ContactService.contactList.add(c1);
					
			assertEquals("1234567890", ContactService.contactList.get(0).getPhoneNumber());
					
			ContactService.updatePhoneNumber("2007", "9876543210");
			assertEquals("9876543210", ContactService.contactList.get(0).getPhoneNumber());
		}
				
		// Testing updateAddress after contact creation
		@DisplayName("Change Address")
		@Test
		void testChangeAddress() {
			Contact c1 = new Contact("2008", "Paul", "James", "1234567890", "100 Slice Lane");
			ContactService.contactList.add(c1);
					
			assertEquals("100 Slice Lane", ContactService.contactList.get(0).getAddress());
					
			ContactService.updateAddress("2008", "800 Fire Drive");
			assertEquals("800 Fire Drive", ContactService.contactList.get(0).getAddress());
		}
				
		// Testing a duplicate ContactID cannot be created
		@DisplayName("No Duplicate ContactID")
		@Test
		void testNoDuplicateID() {
			boolean addTest = false;
			
			Contact c1 = new Contact("7000", "Bob", "Builder", "9998887777", "87 Sweet Home Alabama");
			addTest = ContactService.addContact(c1);
			
			assertTrue(addTest);
			
			Contact c2 = new Contact("7000", "Bobby", "Build", "7777888999", "78 Sweet Home Alabama");
			addTest = ContactService.addContact(c2);
			
			assertFalse(addTest);
					
		}
		
}
