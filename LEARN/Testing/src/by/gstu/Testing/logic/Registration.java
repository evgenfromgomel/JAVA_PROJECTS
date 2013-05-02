package by.gstu.Testing.logic;

import java.io.UnsupportedEncodingException;

import by.gstu.Testing.interfacesDAO.StudentDAO;
import by.gstu.Testing.interfacesDAO.SubjectDAO;
import by.gstu.Testing.interfacesDAO.TutorDAO;
import by.gstu.Testing.managerDAO.DAOFactory;
import by.gstu.Testing.resource.Resource;

/**
 * Provides adding new user to data base.
 *
 */
public class Registration {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	public static boolean addUser(String login, String password,
			String lastname, String firstname, String accesstype, String role)
			throws UnsupportedEncodingException, ClassNotFoundException {

		boolean additionResult = false;

		if (role.equals(Resource.getJspParams("param.register.usertype.tutor"))) {
			String currPost = "";
			for (int i = 0; i < 4; i++) {
				if (accesstype.equals(Resource
						.getJspParams("param.testcreate.avar") + i)) {
					currPost = new String(Resource.getJspParams(
							"param.register.accesoryvar" + (i + 1) + ".tutor")
							.getBytes("ISO-8859-1"), "UTF-8");
				}
			}
			TutorDAO currentTutor = mysqlFactory.getTutorDAO();
			additionResult = currentTutor.insertTutor(lastname, firstname, currPost, login,
					password);
		} else if (role.equals(Resource
				.getJspParams("param.register.usertype.student"))) {
			String currGroup = "";
			for (int i = 0; i < 4; i++) {
				if (accesstype.equals(Resource
						.getJspParams("param.testcreate.avar") + i)) {
					currGroup = new String(Resource
							.getJspParams(
									"param.register.accesoryvar" + (i + 1)
											+ ".student")
							.getBytes("ISO-8859-1"), "UTF-8");
				}
			}
			StudentDAO currentStudent = mysqlFactory.getStudentDAO();
			additionResult = currentStudent.insertStudent(lastname, firstname,
					currGroup, login, password);
		}
		return additionResult;
	}
}
