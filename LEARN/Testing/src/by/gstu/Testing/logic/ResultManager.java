package by.gstu.Testing.logic;

import java.util.List;

import by.gstu.Testing.managerDAO.DAOFactory;
import by.gstu.Testing.interfacesDAO.ResultDAO;
import by.gstu.Testing.interfacesDAO.StudentDAO;
import by.gstu.Testing.interfacesDAO.TestDAO;
import by.gstu.Testing.entities.Result;
import by.gstu.Testing.entities.Student;
import by.gstu.Testing.entities.Test;

public class ResultManager {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	public static void addTestResult(int idStudent, int idTest, double result) throws ClassNotFoundException {

		ResultDAO setResult = mysqlFactory.getResultDAO();
		setResult.insertResult(idStudent, idTest, result);
	}

	public static List<Result> getAllResults() throws ClassNotFoundException {

		ResultDAO results = mysqlFactory.getResultDAO();
		return results.selectAll();
	}

	public static List<Result> getStudentResults(int idStudent) throws ClassNotFoundException {

		ResultDAO results = mysqlFactory.getResultDAO();
		return results.selectByStudent(idStudent);
	}

	public static String getStudentName(int studentId) throws ClassNotFoundException {
		StudentDAO tempStudent = mysqlFactory.getStudentDAO();
		Student currStudent = tempStudent.getStudentById(studentId);
		String outputLine = currStudent.getLastName() + " "
				+ currStudent.getFirstName();
		return outputLine;
	}

	public static String getTestName(int idTest) throws ClassNotFoundException {
		TestDAO tempTest = mysqlFactory.getTestDAO();
		return tempTest.getTestNameById(idTest);
	}
}
