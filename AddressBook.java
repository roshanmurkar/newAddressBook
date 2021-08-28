package FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	private static Scanner sc = new Scanner(System.in);
	private static File file = new File("AddressBook.txt");
	static List<Contact> contact = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		readPeopleFromFile();
		showMainMenu();
	}

	public static void addContact() throws IOException {
		System.out.println("Enter Firstname: ");
		String firstname = sc.nextLine();
		System.out.println("Enter Lastname: ");
		String lastname = sc.nextLine();
		System.out.println("Enter City: ");
		String city = sc.nextLine();
		System.out.println("Enter State: ");
		String state = sc.nextLine();
		System.out.println("Enter ZipCode: ");
		String zip = sc.nextLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();
		System.out.println("Enter Email Id: ");
		String email = sc.nextLine();

		Contact contactDetail = new Contact(firstname, lastname, city, state, zip, phoneNumber, email);
		addToFile(contactDetail);
		contact.add(contactDetail);
		System.out.println("Added person: " + contactDetail);
		System.out.println();
		showMainMenu();
	}

	private static void addToFile(Contact contact) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write(contact.toString());
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static boolean readPeopleFromFile() throws IOException {
		List<Contact> contact = new ArrayList<Contact>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String name = null;
			while ((name = reader.readLine()) != null) {
				Contact contact1 = new Contact(name, reader.readLine(), reader.readLine(), reader.readLine(),
						reader.readLine(), name, name);
				contact.add(contact1);
				reader.readLine();
			}
			return true;
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

	public static void printData() throws IOException {
		try {
			Files.lines(new File("AddressBook.txt").toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void showMainMenu() throws IOException {
		System.out.println("1. Add person");
		System.out.println("2. Show all contact details");
		System.out.println("3. Exit from the program");

		String choice;
		do {
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				addContact();
				break;
			case "2":
				printData();
				showMainMenu();
				break;
			case "3":
				System.out.println("Thank You..");
				System.exit(0);
				break;
			default:
				System.out.println("Enter numer from 1 to 3");
			}
		} while (!choice.equals("3"));
	}
}
