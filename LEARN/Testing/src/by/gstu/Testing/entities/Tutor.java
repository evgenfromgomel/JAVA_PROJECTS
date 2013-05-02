package by.gstu.Testing.entities;

public class Tutor {
	private int tutorId;
	private String lastName;
	private String firstName;
	private String post;
	private String login;
	private String password;
	private String role;

	public Tutor(int idValue, String lastNameVal, String firstNameVal,
			String postVal,String loginVal,String passwordVal) {
		tutorId = idValue;
		lastName = lastNameVal;
		firstName = firstNameVal;
		post = postVal;
		login = loginVal;
		password = passwordVal;
		role = "tutor";
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int idValue) {
		tutorId = idValue;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String nameValue) {
		lastName = nameValue;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String nameValue) {
		firstName = nameValue;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String postValue) {
		post = postValue;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String loginValue) {
		login = loginValue;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordValue) {
		password = passwordValue;
	}

	public String getRole(){
		return role;
	}
	public String toString() {
		return tutorId + " " + lastName + " " + firstName + " "
				+ post;
	}
}
