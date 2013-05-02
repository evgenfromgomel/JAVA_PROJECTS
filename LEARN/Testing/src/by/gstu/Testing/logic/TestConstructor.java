package by.gstu.Testing.logic;

import java.util.List;

import by.gstu.Testing.entities.Question;
import by.gstu.Testing.interfacesDAO.QuestionDAO;
import by.gstu.Testing.interfacesDAO.TestDAO;
import by.gstu.Testing.interfacesDAO.TestSpecifDAO;
import by.gstu.Testing.managerDAO.DAOFactory;

public class TestConstructor {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	public static void addNewTest(String nameTestVal, int subjectIdValue) throws ClassNotFoundException {
		TestDAO newTest = mysqlFactory.getTestDAO();
		newTest.insertTest(nameTestVal, subjectIdValue);
	}

	public static void addNewTestSpecif(int testIdVal, int[] questionIdListVal) throws ClassNotFoundException {
		TestSpecifDAO newTestSpec = mysqlFactory.getTestSpecifDAO();
		newTestSpec.insertTestSpecif(testIdVal, questionIdListVal);
	}

	public static int getTestId(String nameTestVal) throws ClassNotFoundException {
		
		TestDAO tempTest = mysqlFactory.getTestDAO();
		return tempTest.findTest(nameTestVal).getTestId();
	}

	public static List<Question> getQuestion(int subjectIdVal) throws ClassNotFoundException {

		
		QuestionDAO tempQuestList = mysqlFactory.getQuestionDAO();
		return tempQuestList.selectQuestionTO(subjectIdVal);
	}
}
