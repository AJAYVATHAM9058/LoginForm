package loginAndRegistrationSystem;

import java.util.*;

public class UserManager {

	
	private List<User> users = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	//Registering a new User
	public void register() {
		
		System.out.println("Enter username :");
		sc.nextLine();
		String username = sc.nextLine();
		
		
		System.out.println("Enter Password  :");
		String password = sc.nextLine();
		
		System.out.println("Enter Email ");
		String email = sc.nextLine();
	
		System.out.println("Enter Secret Question : ");
		String secretQuestion = sc.nextLine();
		
		System.out.println("Enter Secret Answer : ");
		String secretAnswer = sc.nextLine();
		
		users.add(new User(username,password,email,secretQuestion,secretAnswer));
		
		System.out.println("Registration Successful");
	}
	
	
	//method for login
	public void login() {
		
		System.out.println("Enter Username ");
		sc.nextLine();
		
		String username = sc.nextLine();
		
		System.out.println(username);
		System.out.println("Enter Password");
		String password = sc.nextLine();
		
		System.out.println(password);
		for(User user : users) {
			
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("Login Successful..\n");
				return;
			}
		}
		
		System.out.println("Login Failed..\n");
		
	}
	
	public void forgotPassword() {
		
		System.out.println("Enter Username or Email Id");
		sc.nextLine();
		String userOrEmail = sc.nextLine();
		
		for(User user : users) {
			if((user.getUsername().equals(userOrEmail)) || (user.getEmail().equals(userOrEmail))) {
				
				System.out.println("Answer the secret Question : \n "+user.getSecretQuestion());
				
				String secretAnswer = sc.nextLine();
				
				
				if(user.getSecretAnswer().equals(secretAnswer)) {
					
					System.out.println("Enter New Password");
					String newPassword = sc.nextLine();
					user.setPassword(newPassword);
					
					System.out.println("Password Reset Successful");
				}
				else {
					System.out.println("Incorrect Answer");
					return;
				}
				
			}
			
			
		}
		
		System.out.println("User Not Found");
	}
	
	
	public void start() {
		
		while(true) {
		
			System.out.println("User Management System");
			
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Forgot Password");
			System.out.println("4. Exit");
			
			System.out.println("Enter Your choice : ");
			int n = sc.nextInt();
			
			switch(n) {
			
			case 1 : register();break;
			case 2 : login(); break;
			case 3 : forgotPassword();break;
			case 4 : System.out.println("Exiting....");return;
			default : System.out.println("Please select 1 , 2, 3, or 4");
						break;
			
			}
			
		
		}
	}
	
	
}
