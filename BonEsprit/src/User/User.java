package User;

import java.util.*;

public class User {
	protected String ID;
	protected String username;
	protected String password;
	protected int type_user;
	protected String first_name;
	protected String last_name;
	protected String email;
	protected int online_status;
	
	
	public User(String ID) {
		this.ID = ID;
		username = "";
		password = "";
		type_user = 0;
		first_name = "";
		last_name = "";
		email = "";
		online_status = 0;
	}

	//function
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
			System.out.print("Enter your new password: ");
			this.password = sc.next();
			break;
		}
		case 2: {
			System.out.println("Enter your new name: ");
			System.out.print("\tFirst name: ");
			this.first_name = sc.nextLine();
			System.out.print("\tLast name: ");
			this.last_name = sc.nextLine();
			break;
		}
		case 3: {
			System.out.print("Enter your new email: ");
			this.email = sc.nextLine();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
		return true;
	}

}