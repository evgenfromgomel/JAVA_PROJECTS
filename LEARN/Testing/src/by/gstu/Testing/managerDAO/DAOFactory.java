package by.gstu.Testing.managerDAO;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;

import by.gstu.Testing.interfacesDAO.QuestionDAO;
import by.gstu.Testing.interfacesDAO.ResultDAO;
import by.gstu.Testing.interfacesDAO.StudentDAO;
import by.gstu.Testing.interfacesDAO.SubjectDAO;
import by.gstu.Testing.interfacesDAO.TestDAO;
import by.gstu.Testing.interfacesDAO.TestSpecifDAO;
import by.gstu.Testing.interfacesDAO.TutorDAO;
import by.gstu.Testing.resource.Resource;

;

public abstract class DAOFactory {

	public static final int MYSQL = 1;

	public abstract TutorDAO getTutorDAO() throws ClassNotFoundException;

	public abstract StudentDAO getStudentDAO() throws ClassNotFoundException;

	public abstract SubjectDAO getSubjectDAO() throws ClassNotFoundException;

	public abstract TestDAO getTestDAO() throws ClassNotFoundException;

	public abstract QuestionDAO getQuestionDAO() throws ClassNotFoundException;

	public abstract TestSpecifDAO getTestSpecifDAO()
			throws ClassNotFoundException;

	public abstract ResultDAO getResultDAO() throws ClassNotFoundException;

	public static DAOFactory getDAOFactory(int numDAOFactory) {

		switch (numDAOFactory) {

		case MYSQL:
			return new MysqlDAOFactory();
		default:
			return null;
		}
	}
}
