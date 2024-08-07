package loginAndRegistrationSystem;

public class User {
	
	private String username;
	private String password;
	private String email;
	private String secretQuestion;
	private String secretAnswer;
	
	//Constructor
	public User(String username, String password, String email, String secretQuestion, String secretAnswer) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
	}
	
	//Getters and Setters
	//methods
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	
}
