package emailApplication;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Name: Chanchev M
 * Date: December 7, 2017
 * Purpose: Email 
 */
public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCap=500;
	private String alternateEmail;
	private int length;
	private String companyEmail= "hireme.com";
	
	//Email constructor
	public Email(String firstName, String lastName, int length) {
		this.firstName= firstName;
		this.lastName= lastName;
		this.length=length;
		
		this.department= setDepartment();
		
		System.out.println("Department: " + this.department);

		//Call method to generate password
		this.password = randomPassword(length);
		System.out.println("Your password is: "+ this.password);
		
		//generate email
		email =firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" +department+"."+companyEmail;
		System.out.println("Your email address is: "+email);
		
	}
	
	private String setDepartment() {
		System.out.print("Enter department\n 1 for sales \n 2 for Dev \n 3 for Accounts \n 0 for none\n");
		Scanner in = new Scanner(System.in);
		int dep =in.nextInt();
		switch(dep) {
		case 0: return "none";
		case 1: return "sales";
		case 2: return "Development";
		case 3: return "Accounts";
		default :return "none";
		}
		
	}
	//generate password
	private String randomPassword(int length) {
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@*&";
		char[] password= new char[length];
	
		for (int x=0;x<length;x++) {
			int ran= (int)(Math.random()*(passwordSet.length()));
			password[x]=passwordSet.charAt(ran);
		}
		
		return new String(password);
		
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCap=capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=alternateEmail;
		
	}
	
	//Change the password
	public void changePassword(String pass) {
		this.password= pass;
	}
	
	public int getMailboxCapacity() {
		return mailboxCap;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	
	
	public String showInfo() {
		return "Display Name: " +firstName + " "+ lastName + 
				"Company Email: "+ email+
				"Mailbox Capacity: "+ mailboxCap + "mb";
		
	}
}
