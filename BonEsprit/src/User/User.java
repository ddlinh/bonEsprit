package User;

import java.util.*;

public class User {
	protected String username;
	protected String password;
	protected int type_user;
	protected String first_name;
	protected String last_name;
	protected String email;
	protected int online_status;
	
	
	public User() {
		username = "";
		password = "";
		type_user = 0;
		first_name = "";
		last_name = "";
		email = "";
		online_status = 0;
	}
	public User(String id, String username, String password, String first_name, String last_name, String email) {
		this.username = username;
		this.password = password;
		this.type_user = -1;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		online_status = 0;
	}
	
	public boolean Login(String username, String password) {
		if(this.online_status == 1)
		{
			System.out.println("This user has't logouted yet, can't process");
			return false;
		}
		else if(this.username.compareTo(username) != 0)
		{
			System.out.println("Username is invalid!");
			return false;
		}
		else if(this.password.compareTo(password) != 0)
		{
			System.out.println("Username is invalid!");
			return false;
		}
		else if(this.username.compareTo(username) != 0 && this.password.compareTo(password) != 0)
		{
			System.out.println("Username & password is invalid!");
			return false;
		}
		this.online_status = 1;
		System.out.print("Login success...");
		return true;
	}
	
	public boolean Logout() {
		if(this.online_status == 0)
			return true;
		else {
			this.online_status = 0;
		}
		System.out.print("See you later...");
		return false;
	}

	public boolean ModifyInfo(int option) {
		if(this.online_status == 0)
		{
			System.out.println("You must login first!");
			return false;
		}
		Scanner sc = new Scanner(System.in);
		switch (option) {
		case 1: {
			System.out.print("Enter your new ID: ");
			this.ID = sc.next();
			
		}
		case 2: {
			System.out.print("Enter your new username: ");
			this.username = sc.next();
		}
		case 3: {
			System.out.print("Enter your new password: ");
			this.password = sc.next();
		}
		case 4: {
			System.out.println("Enter your new name: ");
			System.out.print("\tFirst name: ");
			this.first_name = sc.next();
			System.out.print("\tLast name: ");
			this.last_name = sc.next();
		}
		case 5: {
			System.out.print("Enter your new email: ");
			this.email = sc.next();
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
	public static void main(String[] args) {
		User u = new User("18126038", "vinhduong", "123", "Vinh", "Duong", "duongquangvinh6@gmail.com");
		u.Login("vinhduong", "123");
			
		
	}
}