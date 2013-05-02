package by.gstu.Testing.logic;

import by.gstu.Testing.entities.Question;
import by.gstu.Testing.interfacesDAO.QuestionDAO;
import by.gstu.Testing.managerDAO.DAOFactory;

public class ReadQuestion {

	public static Question getQuestion(int questId) throws ClassNotFoundException {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		QuestionDAO questDAO = mysqlFactory.getQuestionDAO();
		Question questRead = questDAO.findQuestion(questId);
		return questRead;
	}

}
