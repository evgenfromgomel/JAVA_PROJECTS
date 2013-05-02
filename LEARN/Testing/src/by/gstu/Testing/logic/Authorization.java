package by.gstu.Testing.logic;

import by.gstu.Testing.entities.Student;
import by.gstu.Testing.entities.Tutor;
import by.gstu.Testing.interfacesDAO.StudentDAO;
import by.gstu.Testing.interfacesDAO.TutorDAO;
import by.gstu.Testing.managerDAO.DAOFactory;

/**
 * This class implements function of checking login and password
 */
public class Authorization {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	/**
	 * @param login
	 * @param password
	 * @return result of checking
	 * @throws ClassNotFoundException
	 */
	public static boolean checkLogin(String login, String password) throws ClassNotFoundException {

		StudentDAO currentStudent = mysqlFactory.getStudentDAO();
		TutorDAO currentTutor = mysqlFactory.getTutorDAO();
		boolean authResult = false;
		Student user1 = currentStudent.getStudentByAuthInfo(login, password);
		Tutor user2 = currentTutor.getTutorByAuthInfo(login, password);
		if (login.length() > 0 && password.length() > 0) {
			if ((user1 != null) && (user1.getLogin().equals(login))
					&& (user1.getPassword().equals(password)))
				authResult = true;
			else if ((user2 != null) && (user2.getLogin().equals(login))
					&& (user2.getPassword().equals(password)))
				authResult = true;
			else
				authResult = false;
		}

		return authResult;
	}

	/**
	 * @param login
	 * @param password
	 * @return user object by authorization info
	 * @throws ClassNotFoundException
	 */
	public static Object getUser(String login, String password) throws ClassNotFoundException {

		StudentDAO currentStudent = mysqlFactory.getStudentDAO();
		TutorDAO currentTutor = mysqlFactory.getTutorDAO();
		Object user = null;
		Student student = currentStudent.getStudentByAuthInfo(login, password);
		Tutor tutor = currentTutor.getTutorByAuthInfo(login, password);

		if ((student.getLogin().equals(login))
				&& (student.getPassword().equals(password)))
			user = student;
		else if ((tutor.getLogin().equals(login))
				&& (tutor.getPassword().equals(password)))
			user = tutor;

		return user;
	}
}