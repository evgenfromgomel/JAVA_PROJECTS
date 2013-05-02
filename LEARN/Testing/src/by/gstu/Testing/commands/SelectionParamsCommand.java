package by.gstu.Testing.commands;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gstu.Testing.logic.ReadSubjects;
import by.gstu.Testing.resource.Resource;


/**
 * This class contain method for determination subject
 *
 */
public class SelectionParamsCommand implements Command {
	private static final int NUM_SUBJECTS = 5;
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ClassNotFoundException {
		String page = "";
		String mainButton = Resource.getJspParams("param.answer.mainbutton");
		String showtestlist = Resource.getJspParams("param.select.showtestslist");
		if (request.getParameter(mainButton).equals(showtestlist)) {
			request.setAttribute(
					Resource.getJspParams("param.testcreate.type"),
					Resource.getJspParams("param.testcreate.hidden"));
			request.setAttribute(
					Resource.getJspParams("param.testcreate.visible"),
					Resource.getJspParams("param.testcreate.true"));
			String[] arrSubjs = ReadSubjects.getSubjArray();
			for (int i = 1; i < NUM_SUBJECTS; i++)
				request.setAttribute(
						Resource.getJspParams("param.testcreate.subj" + i),
						arrSubjs[i - 1]);
			page = Resource.getJspParams("test.list.path");
		}

		return page;
	}

}