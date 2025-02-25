/*
 * Developer: Ryan Sitner
 * Date: 1/23/2025
 */

package main;
import java.util.ArrayList;

public class ContactService {
	
	// Create new array list to store contacts
	static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	// Create new Contact object and add it to ArrayList as long as contactID is unique
	public static boolean addContact(Contact newContact) {
		boolean addSuccessful = false;
		
		if (contactList.size() == 0) {
			contactList.add(newContact);
			addSuccessful = true;
		}
		else {
			for (Contact c : contactList) {
				if (newContact.getContactID().equalsIgnoreCase(c.getContactID())) {
					return addSuccessful;
				}
			}
			contactList.add(newContact);
			addSuccessful = true;
		}
		
		return addSuccessful;
		
	}
	
	// Delete a contact from contactList based on unique contactID
	public static void deleteContact(String contactID) {
		// Going through all of contractList
		for (int i = 0; i < contactList.size(); ++i) {
			// If index(i) matches the entered contactID
			if (ContactService.contactList.get(i).getContactID() == contactID) {
				// Remove entry at i
				contactList.remove(i);
			}
		}
	}
	
	
	// Updater Methods:
	
	public static void updateFirstName(String contactID, String firstName) {
		for (int i = 0; i < contactList.size(); ++i) {
			// If contactID matches current Array contactID, set firstName
			if (contactID.compareTo(contactList.get(i).getContactID()) == 0) {
				contactList.get(i).setFirstName(firstName);
			}
		}
	}
	
	public static void updateLastName(String contactID, String lastName) {
		for (int i = 0; i < contactList.size(); ++i) {
			// If contactID matches current Array contactID, set lastName
			if (contactID.compareTo(contactList.get(i).getContactID()) == 0) {
				contactList.get(i).setLastName(lastName);
			}
		}
	}
	
	public static void updatePhoneNumber(String contactID, String phoneNumber) {
		for (int i = 0; i < contactList.size(); ++i) {
			// If contactID matches current Array contactID, set phoneNumber
			if (contactID.compareTo(contactList.get(i).getContactID()) == 0) {
				contactList.get(i).setPhoneNumber(phoneNumber);
			}
		}
	}
	
	public static void updateAddress(String contactID, String address) {
		for (int i = 0; i < contactList.size(); ++i) {
			// If contactID matches current Array contactID, set address
			if (contactID.compareTo(contactList.get(i).getContactID()) == 0) {
				contactList.get(i).setAddress(address);
			}
		}
	}
	
}
