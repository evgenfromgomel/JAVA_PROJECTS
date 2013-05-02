package by.gstu.Testing.logic;

import java.util.List;
import by.gstu.Testing.entities.TestSpecif;
import by.gstu.Testing.interfacesDAO.TestDAO;
import by.gstu.Testing.interfacesDAO.TestSpecifDAO;
import by.gstu.Testing.managerDAO.DAOFactory;

public class TestSelector {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	public static List<TestSpecif> getTests() throws ClassNotFoundException {
		TestSpecifDAO tests = mysqlFactory.getTestSpecifDAO();
		return tests.selectTestTO();
	}

	public static String getTestName(int idTestVal) throws ClassNotFoundException {
		TestDAO tempTest = mysqlFactory.getTestDAO();
		return tempTest.getTestNameById(idTestVal);
	}

	public static int getSubjectId(int idTestVal) throws ClassNotFoundException {
		TestDAO tempTest = mysqlFactory.getTestDAO();
		return tempTest.findTest(tempTest.getTestNameById(idTestVal))
				.getSubjectId();
	}
}
