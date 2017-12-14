import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AddressBook2 implements Serializable{
	private String firstName;
	private String lastName;
	private int addressNum;
	private String addressStreetName;
	private int zipCode;
	private String city;
	private String state;
	private int areaCode;
	private String phone;
	private String email;
	
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getAddressNum() {
		return addressNum;
	}



	public void setAddressNum(int addressNum) {
		this.addressNum = addressNum;
	}



	public String getAddressStreetName() {
		return addressStreetName;
	}



	public void setAddressStreetName(String addressStreetName) {
		this.addressStreetName = addressStreetName;
	}



	public int getZipCode() {
		return zipCode;
	}



	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getAreaCode() {
		return areaCode;
	}



	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public void AddressBook (String firstName, String lastName, int addressNum, String addressStreetName, int zipCode, String city, String state, int areaCode, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressNum = addressNum;
		this.addressStreetName = addressStreetName;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.areaCode = areaCode;
		this.phone = phone;
		this.email = email;
	
	}
	private static final String file = "C:\\Users\\0050\\Desktop\\addressbook.txt";
	
	public static void main (String [] args) {
		BufferedWriter in = null;
		FileWriter out = null;
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		String code = null;

		try {
			out = new FileWriter(file);
			in = new BufferedWriter(out);
			fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			
		do {	
			AddressBook2 book = new AddressBook2();
			
			System.out.println("Enter first name: ");
			Scanner scan = new Scanner(System.in);
			String fName = scan.nextLine();
			book.setFirstName(fName);
			
			
			System.out.println("Enter last name: ");
			Scanner scan2 = new Scanner(System.in);
			String lName = scan2.nextLine();
			book.setLastName(lName);
			
			
			System.out.println("Enter street address: ");
			Scanner scan3 = new Scanner(System.in);
			String address = scan3.nextLine();
			book.setAddressStreetName(address);
			
			System.out.println("Enter city: ");
			Scanner scan4 = new Scanner(System.in);
			String city = scan4.nextLine();
			book.setCity(city);
			
			System.out.println("Enter state: ");
			Scanner scan5 = new Scanner(System.in);
			String state = scan5.nextLine();
			book.setState(state);
			
			System.out.println("Enter zip code: ");
			Scanner scan6 = new Scanner(System.in);
			int zipCode = scan6.nextInt();
			book.setZipCode(zipCode);
			
			System.out.println("Enter phone number: ");
			Scanner scan7 = new Scanner(System.in);
			String phone = scan7.nextLine();
			book.setPhone(phone);
			
			System.out.println("Enter email: ");
			Scanner scan8 = new Scanner(System.in);
			String email = scan8.nextLine();
			book.setEmail(email);

			System.out.println(book.lastName);
			oos.writeObject(book);
			oos.close();
			
			System.out.println("Add another address Y or n: ");
			Scanner scan9 = new Scanner(System.in);
			code = scan9.nextLine();
			
			
			
		}while (code.equalsIgnoreCase("y"));
		
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (in != null)
					in.close();

				if (out != null)
					out.close();

			} catch (IOException ex) {

				ex.printStackTrace();
				
				if (fout != null) {
					try {
						fout.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

		}
	}	
}