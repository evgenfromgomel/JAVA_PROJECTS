package by.gstu.Testing.logic;

import java.util.ArrayList;
import java.util.List;

import by.gstu.Testing.entities.Question;
import by.gstu.Testing.entities.TestSpecif;
import by.gstu.Testing.interfacesDAO.TestSpecifDAO;
import by.gstu.Testing.managerDAO.DAOFactory;

public class AnswerQuestionHelper {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	/**
	 * @param testId
	 * @return Question list by test id
	 * @throws ClassNotFoundException
	 */
	public static List<Integer> getQuestionlist(int testId) throws ClassNotFoundException {
		TestSpecifDAO testspecDAO = mysqlFactory.getTestSpecifDAO();
		TestSpecif s = testspecDAO.findTestSpecif(testId);
		return s.getQuestionList();
	}

	/**
	 * @param answer
	 * @param currQuestion
	 * @return result of answer of question
	 */
	public static boolean checkAnswerResult(int answer, Question currQuestion) {
		boolean answerResult = false;
		if (answer == currQuestion.getRightAnswer())
			answerResult = true;

		return answerResult;
	}
}
