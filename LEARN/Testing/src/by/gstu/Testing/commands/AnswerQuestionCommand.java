package by.gstu.Testing.commands;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.gstu.Testing.entities.Question;
import by.gstu.Testing.entities.Student;
import by.gstu.Testing.logic.AnswerQuestionHelper;
import by.gstu.Testing.logic.ReadQuestion;
import by.gstu.Testing.logic.ResultManager;
import by.gstu.Testing.resource.Resource;

/**
 * This class process and prepare request for questionPage.jsp and  
 * provide logic for result calculating when test will be complete
 */
public class AnswerQuestionCommand implements Command {
	
	private static final int  ANSWER_NUMBER = 5;
	private static final int  MARK_COEFFICIENT = 10;
	static Logger logger = Logger.getLogger(AnswerQuestionCommand.class);

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ClassNotFoundException {
		String page = "";
		//read parameters for compare
		String answerButton = Resource.getJspParams("param.answer.answerbutton");
		String nextButton = Resource.getJspParams("param.answer.next");
		int currResult = 0;
		if (answerButton.equals(nextButton)) {
			//if was pressed button "Next"
			HttpSession currsession = request.getSession();
			int currcount = (Integer) currsession.getAttribute(Resource
					.getJspParams("param.answer.countquest"));

			List<Integer> questionsIdList = (ArrayList<Integer>) currsession
					.getAttribute(Resource
							.getJspParams("param.answer.currenttest"));
			int numQuestions = (Integer) currsession.getAttribute(Resource
					.getJspParams("param.answer.numquestions"));
			currResult = (Integer) currsession.getAttribute(Resource
					.getJspParams("param.answer.currresult"));
			int answer = 0;
			for (int i = 1; i < ANSWER_NUMBER; i++)
				if (request.getParameter(Resource
						.getJspParams("param.answer.curranswer") + i) != null) {
					answer = i;

					break;
				}

			if (currcount < numQuestions) {
				//if question are not last
				Question currQuestion = ReadQuestion
						.getQuestion(questionsIdList.get(currcount));
				if (AnswerQuestionHelper.checkAnswerResult(answer, ReadQuestion
						.getQuestion(questionsIdList.get(currcount - 1)))) {
					currResult++;

				}
				currsession.setAttribute(
						Resource.getJspParams("param.answer.currresult"),
						currResult);
				currcount++;
				currsession.setAttribute(
						Resource.getJspParams("param.answer.countquest"),
						currcount);
				request.setAttribute(
						Resource.getJspParams("param.answer.textquest"),
						currQuestion.getQuestionText());
				request.setAttribute(
						Resource.getJspParams("param.answer.variant1"),
						currQuestion.getVarA());
				request.setAttribute(
						Resource.getJspParams("param.answer.variant2"),
						currQuestion.getVarB());
				request.setAttribute(
						Resource.getJspParams("param.answer.variant3"),
						currQuestion.getVarC());
				request.setAttribute(
						Resource.getJspParams("param.answer.variant4"),
						currQuestion.getVarD());
				page = Resource.getJspParams("question.page.path");
			} else {
				//if test complete
				numQuestions = (Integer) currsession.getAttribute(Resource
						.getJspParams("param.answer.numquestions"));
				currResult = (Integer) currsession.getAttribute(Resource
						.getJspParams("param.answer.currresult"));
				answer = 0;
				for (int i = 1; i < ANSWER_NUMBER; i++)
					if (request.getParameter(Resource
							.getJspParams("param.answer.curranswer") + i) != null) {
						answer = i;
						break;
					}
				if (AnswerQuestionHelper.checkAnswerResult(answer, ReadQuestion
						.getQuestion(questionsIdList.get(currcount - 1)))) {
					currResult++;

				}
				//calculate result of testing
				double resultOfTest = ((double) currResult / (double) numQuestions) * MARK_COEFFICIENT;
				request.setAttribute(
						Resource.getJspParams("param.answer.result"),
						Math.round(resultOfTest));
				Student currStudent = (Student) currsession
						.getAttribute(Resource
								.getJspParams("login.current.user"));
				ResultManager.addTestResult(currStudent.getStudentId(),
						(Integer) currsession.getAttribute(Resource
								.getJspParams("param.answer.currtestid")), Math
								.round(resultOfTest));
				page = Resource.getJspParams("finaltest.page.path");
				logger.info("test comleted, result" + resultOfTest);
			}
		}

		return page;
	}

}