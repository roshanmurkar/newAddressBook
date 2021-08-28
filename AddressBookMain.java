package com.AddressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

	static String fname;
	static Scanner s = new Scanner(System.in);

	public static void addAddressBook(Map<String, List<Contact>> addressBooks) {
		System.out.println("Add new AddressBook");
		String bookName = s.next();
		addressBooks.put(bookName, new ArrayList<Contact>());
	}

	public static void displayAllAddressBook(Map<String, List<Contact>> addressBooks) {
		boolean is_Empty = addressBooks.isEmpty();
		if (is_Empty == true)
			System.out.println("No Address Books are Present");
		else
			System.out.println(addressBooks);
	}

	public static void editAddressBook(Map<String, List<Contact>> addressBooks) {
		System.out.println("Enter the name of the AddressBook you want to Edit");
		String bookName1 = s.next();

		if (addressBooks.containsKey(bookName1)) {
			List<Contact> contact = addressBooks.get(bookName1);
			int choice;
			do {
				System.out.println("Enter your option : ");
				System.out.println("1.Add contact  ");
				System.out.println("2.Display all contact ");
				System.out.println("3.Edit Contact ");
				System.out.println("4.Delete Contact ");
				System.out.println("5.Search Contact by City");
				System.out.println("6.View Contact's First Name and Last Name by City ");
				System.out.println("7.Count of Total Contacts By City");
				System.out.println("8.Count of Total Contacts By State");
				System.out.println("9.Sort Contacts by first Name");
				choice = s.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Add Contact  \n");
					System.out.print("Enter First Name :");
					String fName = s.next();

					if (AddressBook.checkDuplicate(fName, contact) == false) {
						AddressBook.addContact();
					} else {
						System.out.println("Already exists");
					}
					break;

				case 2:
					AddressBook.displayAll();
					break;
				case 3:
					AddressBook.editContact();
					break;
				case 4:
					AddressBook.deleteContact();
					break;
				case 5:
					AddressBook.searchByCityOrState(contact);
					break;
				case 6:
					AddressBook.viewPersonByCityOrState(contact);
					break;
				 case 7:
					 AddressBook.countByCity(contact);
                     break;
                 case 8:
                	 AddressBook.countByState(contact);
                     break;
                 case 9:
                	 AddressBook.sortedContactByFirstName(contact);
                     break;
				default:
					System.out.println("Enter valid option");
					break;
				}
				System.out.println("Do you want to continue (1.Continue or 0.Exit)");
				choice = s.nextInt();
			} while (choice != 0);
		} else
			System.out.println("Invalid AddressBook Name!Not exist");
	}

	public static void main(String[] args) {

		int option;
		Map<String, List<Contact>> addressBooks = new HashMap<String, List<Contact>>();
		do {
			System.out.println(
					"Enter 1 to Create AddressBook\nEnter 2 for adding contact to AddressBook\nEnter 3 to see All Address Books Name\n"
							+ "Enter 0 to Exit");
			option = s.nextInt();
			switch (option) {
			case 1:
				AddressBookMain.addAddressBook(addressBooks);
				break;
			case 2:
				AddressBookMain.editAddressBook(addressBooks);
				break;
			case 3:
				AddressBookMain.displayAllAddressBook(addressBooks);
				break;
			default:
				System.out.println("Thank You");
				System.exit(0);

				break;
			}
		} while (option != 0);
	}
}
