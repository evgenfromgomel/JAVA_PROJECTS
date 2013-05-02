package by.gstu.Testing.interfacesDAO;

import java.util.List;

import by.gstu.Testing.entities.Question;


public interface QuestionDAO {
	public void insertQuestion(int subjectIdVal,String textQuestionVal, 
			String varAval,String varBval,String varCval,String varDval);

	public Question findQuestion(int questionId);

	public List<Question> selectQuestionTO(int subjectIdVal);
}
