package by.gstu.Testing.interfacesDAO;

import java.util.List;

import by.gstu.Testing.entities.Student;


public interface StudentDAO {
	public boolean insertStudent(String lastNameVal, String firstNameVal,
			String groupVal, String login, String password);

	public boolean deleteStudent(String lastNameVal);

	public Student findStudent(String lastNameVal);
	
	public Student getStudentByAuthInfo(String login, String password);

	public List<Student> selectStudentTO(String postVal);
	
	public Student getStudentById(int studentId);
}
