package MySQL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Read_Write_Contact_asCSV {
	public static void main(String args[]) throws IOException {

		FileOutputStream fos = new FileOutputStream("AddressBook.csv");
		PrintWriter pw = new PrintWriter(fos);
		pw.println("FirstName, LastName, Address, City, State, Zip, PhoneNumber, Email");
		pw.println("pranali, murkar, 998Sawantwadi, Sawantwadi, Sindhudurg, 416510, 1212121212, pranali@gmail.com");
		pw.println("roshan, murkar, 998Sawantwadi, Sawantwadi, Sindhudurg, 416510, 1234567890,roshan@gmail.com");
		pw.println("raj, thakur, Sawantwadi, Sawantwadi, Sindhudurg, 416510, 0987654321,raj@gmail.com");
		pw.println("mohit, shukla, 998Sawantwadi, Sawantwadi, Sindhudurg, 416510, 1234567890,mohit@gmail.com");
		pw.println("roshan, murkar, 998Sawantwadi, Sawantwadi, Sindhudurg, 416510, 1234567890,roshan@gmail.com");
		pw.close();
		System.out.println("Writting into CSV file successfully");

		Scanner sc = new Scanner(new File("C:\\Users\\ACER\\eclipse-workspace\\Java JDBC\\AddressBook.csv"));
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.print(sc.next());
		}
		sc.close();

	}

}
