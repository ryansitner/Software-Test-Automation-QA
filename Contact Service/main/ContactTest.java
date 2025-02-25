/*
 * Developer: Ryan Sitner
 * Date: 1/23/2025
 */

package main;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	@DisplayName("Test Valid Contact Creation")
	@Test
	void testGoodContact() {
		
		// Creating the new contact with set variables
		Contact newContact = new Contact("1001", "John", "Doe", "0123456789", "1 Main St, New York, NY 01234");
		
		// Confirming contact information is correct
		assertEquals("1001", newContact.getContactID());
		assertEquals("John", newContact.getFirstName());
		assertEquals("Doe", newContact.getLastName());
		assertEquals("0123456789", newContact.getPhoneNumber());
		assertEquals("1 Main St, New York, NY 01234", newContact.getAddress());		
	}
	
	// Test to confirm contact cannot be added with a null first name
	@DisplayName("Test Null First Name")
	@Test
	void testNullName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1002", null, "Elliot", "3333334444", "123 Second Street");
		});
	}
	
	// Test to confirm contact cannot be added with a phone number less than 10 characters
	@DisplayName("Test Phone Number Too Short")
	@Test
	void testShortPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1003", "Brandon", "Ertz", "98765", "17 Street Avenue");
		});
	}
	
	// Test to confirm contact cannot be added with a phone number greater than 10 characters
	@DisplayName("Test Phone Number Too Long")
	@Test
	void testLongPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10031", "Brandon", "Ertz", "98765123456789", "17 Street Avenue");
		});
	}
	
	// Test to confirm contact cannot be added with a null phone number
	@DisplayName("Test Phone Number Null")
	@Test
	void testNullPhone() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact("10032", "Brandon", "Ertz", null, "17 Street Avenue");
		});
	}
	
	// Test to confirm contact cannot be added with a phone number that contains letters
	@DisplayName("Test Phone Number with Letters")
	@Test
	void testLettersPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10032", "Brandon", "Ertz", "84596g2571", "17 Street Avenue");
		});
	}
	
	// Test to confirm contact cannot be added with an ID greater than 10 characters
	@DisplayName("Test ID Too Long")
	@Test
	void testLongID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678999", "Ryan", "Wentz", "1467953158", "123 Fake Street");
		});
	}
	
	// Test to confirm contact cannot be added with address greater than 30 characters
	@DisplayName("Test Address Too Long")
	@Test
	void testLongAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1004", "Kim", "Enloe", "9876543210", "Is this over 30 characters? Not yet? How about now?");
		});
	}
	
	// Test to confirm contact last name cannot be updated to null
	@DisplayName("Set Last Name Null")
	@Test
	void testSetLastName() {
		Contact newContact = new Contact("1005", "Tim", "Pederson", "9632587410", "32 Bluff Drive");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	
	// Test to confirm contact address can be updated with valid input
	@DisplayName("Good setAddress")
	@Test
	void testGoodSetAddress() {
		Contact newContact = new Contact("1006", "Cameron", "Smith", "2013654789", "77 Hike Hill");
		newContact.setAddress("123 Perfect Way");
		assertEquals("123 Perfect Way", newContact.getAddress());
	}
	
	// Test to confirm contact address cannot be updated to null
	@DisplayName("Set Address Null")
	@Test
	void testSetAddressNull() {
		Contact newContact = new Contact("1007", "Mike", "Gowen", "8627964665", "418 Totally Real Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
	
	// Test to confirm contact phone number can be updated with valid input
	@DisplayName("Good setPhoneNumber")
	@Test
	void testGoodSetPhone() {
		Contact newContact = new Contact("1008", "Pike", "Trickfoot", "9517536842", "2215 Taldorea Way");
		newContact.setPhoneNumber("1111111112");
		assertEquals("1111111112", newContact.getPhoneNumber());
	}
	
	// Test to confirm contact last name cannot be added with a last name greater than 10 characters
	@DisplayName("Test Last Name Too Long")
	@Test
	void testLongLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1009", "Percy", "Fredrickstein Von Musel Klossowski de Rolo III", "1110002229", "11 Whitestone Jaffe");
		});
	}

}
