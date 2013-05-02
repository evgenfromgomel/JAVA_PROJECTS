package by.gstu.Testing.commands;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.gstu.Testing.entities.Question;
import by.gstu.Testing.entities.TestSpecif;
import by.gstu.Testing.logic.AnswerQuestionHelper;
import by.gstu.Testing.logic.ReadQuestion;
import by.gstu.Testing.resource.Resource;

/**
 * This class prepare basic parameters for testing. Also here loads first question of
 * selected test
 */
public class FirstQuestionCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ClassNotFoundException {
		String page = "";
		String mainButton = Resource.getJspParams("param.answer.mainbutton");
		String startTest = Resource.getJspParams("param.answer.starttest");
		if (request.getParameter(mainButton).equals(startTest)) {
			HttpSession currsession = request.getSession();

			List<TestSpecif> currTestList = (ArrayList<TestSpecif>) currsession
					.getAttribute(Resource
							.getJspParams("param.select.testIdList"));
			String checkedTest = (String) request.getAttribute(Resource
					.getJspParams("param.select.numcheck"));

			int currCheckedTest = 0;
			String s = "";

			for (int i = 0; i < currTestList.size(); i++)
				if (request.getParameter(Resource
						.getJspParams("param.select.numcheck") + i) != null) {
					currCheckedTest = i;
					break;
				}
			int currCheckedIdTest = currTestList.get(currCheckedTest)
					.getTestId();
			List<Integer> questionsIdList = AnswerQuestionHelper
					.getQuestionlist(currCheckedIdTest);
			int currResult = 0;
			currsession.setAttribute(
					Resource.getJspParams("param.answer.currenttest"),
					questionsIdList);
			currsession.setAttribute(
					Resource.getJspParams("param.answer.currtestid"),
					currCheckedIdTest);
			currsession.setAttribute(
					Resource.getJspParams("param.answer.numquestions"),
					questionsIdList.size());
			currsession.setAttribute(
					Resource.getJspParams("param.answer.currresult"),
					currResult);
			int currcount = 0;
			Question currQuest = ReadQuestion.getQuestion(questionsIdList
					.get(currcount));
			currcount++;
			currsession
					.setAttribute(
							Resource.getJspParams("param.answer.countquest"),
							currcount);
			request.setAttribute(
					Resource.getJspParams("param.answer.textquest"),
					currQuest.getQuestionText());
			request.setAttribute(
					Resource.getJspParams("param.answer.variant1"),
					currQuest.getVarA());
			request.setAttribute(
					Resource.getJspParams("param.answer.variant2"),
					currQuest.getVarB());
			request.setAttribute(
					Resource.getJspParams("param.answer.variant3"),
					currQuest.getVarC());
			request.setAttribute(
					Resource.getJspParams("param.answer.variant4"),
					currQuest.getVarD());
			page = Resource.getJspParams("question.page.path");
		}
		return page;
	}

}