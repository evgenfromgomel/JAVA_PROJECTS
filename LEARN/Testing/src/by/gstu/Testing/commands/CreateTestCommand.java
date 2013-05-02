package by.gstu.Testing.commands;



import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.util.List;
import by.gstu.Testing.entities.Question;
import by.gstu.Testing.logic.ReadSubjects;
import by.gstu.Testing.logic.TestConstructor;
import by.gstu.Testing.resource.Resource;

/**
 * This class show question list by selected subject. User add selected questions 
 * to data base and test creation ends
 */
public class CreateTestCommand implements Command {
	static Logger logger = Logger.getLogger(CreateTestCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			UnsupportedEncodingException, ClassNotFoundException {
		String page = "";
		String createButton = Resource.getJspParams("param.testcreate.createbutton");
		String continueButton = Resource.getJspParams("param.testcreate.continue");
		String addTestButton = Resource.getJspParams("param.testcreate.addtest");
		if (request.getParameter(createButton).equals(continueButton)) {
			
			String type = Resource.getJspParams("param.testcreate.type");
			String submit = Resource.getJspParams("param.testcreate.submit");
			request.setAttribute(type,submit);
			
			int subjectId = Integer.valueOf(request.getParameter(Resource
					.getJspParams("param.testcreate.subjectlist")));
			String nameTestVal = request.getParameter(Resource
					.getJspParams("param.testcreate.testname"));
			String subject = Resource.getJspParams("param.testcreate.subject");
			request.setAttribute(subject,ReadSubjects.getSubj(subjectId));
			
			TestConstructor.addNewTest(nameTestVal, subjectId);
			int currTestId = TestConstructor.getTestId(nameTestVal);
			HttpSession session = request.getSession(true);
			session.setAttribute(Resource.getJspParams("session.testname"),
					currTestId);

			List<Question> currQuestList = TestConstructor
					.getQuestion(subjectId);
			String outputTable = "";
			for (int i = 0; i < currQuestList.size(); i++) {

				outputTable += Resource.getJspParams("general.tag1")
						+ currQuestList.get(i).getQuestionText()
						+ Resource.getJspParams("param.testcreate.tag1") + i
						+ Resource.getJspParams("param.testcreate.tag2") + i
						+ Resource.getJspParams("param.testcreate.tag3") + "\n";
			}
			String questionListStr = Resource.getJspParams("param.testcreate.questionslist");
			session.setAttribute(questionListStr,currQuestList);
			String questTableStr = Resource.getJspParams("param.testcreate.questtable");
			request.setAttribute(questTableStr,	outputTable);
			page = Resource.getJspParams("test.creation.path");
			logger.info("subject" + ReadSubjects.getSubj(subjectId)
					+ "selected");
		} else if (request.getParameter(createButton).equals(addTestButton)) {
			HttpSession session = request.getSession();
			List<Question> currQuestions = (List<Question>) session
					.getAttribute(Resource
							.getJspParams("param.testcreate.questionslist"));
			int[] idListQuestions = new int[currQuestions.size()];
			int tempIterator = 0;
			for (int i = 0; i < currQuestions.size(); i++)
				if (request.getParameter(Resource
						.getJspParams("param.testcreate.numcheck") + i) != null) {
					idListQuestions[tempIterator] = currQuestions.get(i)
							.getQuestionId();
					tempIterator++;
				}
			int currTestId = (Integer) session.getAttribute(Resource
					.getJspParams("session.testname"));
			TestConstructor.addNewTestSpecif(currTestId, idListQuestions);

	
			page = Resource.getJspParams("success.page.path");
			logger.info("test " + currTestId + " created");
		}
		return page;
	}

}