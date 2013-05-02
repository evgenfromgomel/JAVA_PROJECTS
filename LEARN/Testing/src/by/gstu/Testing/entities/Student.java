package by.gstu.Testing.entities;

public class Student {
	private int studentId;
	private String lastName;
	private String firstName;
	private String group;
	private String login;
	private String password;
	private String role;

	public Student(int idValue, String lastNameVal, String firstNameVal,
			String groupVal,String loginVal,String passwordVal) {
		studentId = idValue;
		lastName = lastNameVal;
		firstName = firstNameVal;
		group = groupVal;
		login = loginVal;
		password = passwordVal;
		role = "student";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int idValue) {
		studentId = idValue;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String groupVal) {
		group = groupVal;
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
	
	public String getRole() {
		return role;
	}

		
	public String toString() {
		return studentId + " " + lastName + " " + firstName + " " +  group;
	}
}
