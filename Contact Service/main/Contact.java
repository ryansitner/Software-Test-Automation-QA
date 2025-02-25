/*
 * Developer: Ryan Sitner
 * Date: 1/23/2025
 */

package main;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	public Contact (
			String contactID,
			String firstName,
			String lastName,
			String phoneNumber,
			String address) {
		
		// Validate contactID
		// If the contact ID is null or greater than 10 characters, throw error
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID Already Taken");
		}
		// Otherwise set variable
		else {
			this.contactID = contactID;
		}
		
		
		// Validate firstName
		// If the first name is null or greater than 10 characters, throw error
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		// Otherwise set variable
		else {
			this.firstName = firstName;
		}
		
		// Validate lastName
		// If the last name is null or greater than 10 characters, throw error
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		// Otherwise set variable
		else {
			this.lastName = lastName;
		}
		
		// Validate phoneNumber is digits only
		try {
	        double phoneNum = Double.parseDouble(phoneNumber);
	    } catch (NumberFormatException nfe) {
	    	throw new IllegalArgumentException("Invalid Phone Number");
	    }
		
		// If phone number is null or isn't exactly 10 characters, throw error
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		// Otherwise set variable
		else {
			this.phoneNumber = phoneNumber;
		}
		
		// Validate address
		// If the address is null or is greater than 30 characters, throw error
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		// Otherwise set variable
		else {
			this.address = address;
		}	
	}
	
	// Getters:
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	// Setters:
	public void setFirstName(String firstName) {
		// If the first name is null or greater than 10 characters, throw error
			if (firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("Invalid First Name");
			}
			// Otherwise set variable
			else {
				this.firstName = firstName;
			}
	}
	
	public void setLastName(String lastName) {
		// If the last name is null or greater than 10 characters, throw error
			if (lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			// Otherwise set variable
			else {
				this.lastName = lastName;
			}
	}
	
	public void setPhoneNumber(String phoneNumber) {
		// If the phone number is null or not exactly 10 characters, throw error
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		// Otherwise set variable
		else {
			this.phoneNumber = phoneNumber;
		}
	}
	
	public void setAddress(String address) {
		// If the address is null or greater than 30 characters, throw error
			if (address == null || address.length() > 30) {
				throw new IllegalArgumentException("Invalid Adress");
			}
			// Otherwise set variable
			else {
				this.address = address;
			}
	}
	
	
}
