package by.gstu.Testing.commands;



import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.gstu.Testing.entities.TestSpecif;
import by.gstu.Testing.logic.ReadSubjects;
import by.gstu.Testing.logic.TestSelector;
import by.gstu.Testing.resource.Resource;


/**
 * This class provides logic for selecting test.  Test list contain tests of selected 
 * subject. 
 */
public class SelectTestCommand implements Command {
	static Logger logger = Logger.getLogger(SelectTestCommand.class);
	private static final int NUM_SUBJECTS = 5;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			UnsupportedEncodingException, ClassNotFoundException {
		String page = "";
		String confirmSelection = Resource.getJspParams("param.select.confirmselection");
		String continueButton = Resource.getJspParams("param.select.continue");
		if (request.getParameter(confirmSelection).equals(continueButton)) {
			request.setAttribute(
					Resource.getJspParams("param.testcreate.type"),
					Resource.getJspParams("param.testcreate.submit"));
			int subjectId = Integer.valueOf(request.getParameter(Resource
					.getJspParams("param.testcreate.subjectlist")));

			request.setAttribute(
					Resource.getJspParams("param.testcreate.subject"),
					ReadSubjects.getSubj(subjectId));

			HttpSession session = request.getSession();

			List<TestSpecif> currTestList = TestSelector.getTests();
			List<TestSpecif> subjTestList = new ArrayList<TestSpecif>();
			List<TestSpecif> finalTestList = new ArrayList<TestSpecif>();
			for (int i = 0; i < currTestList.size(); i++) {
				if (TestSelector.getSubjectId(currTestList.get(i).getTestId()) == subjectId)
					subjTestList.add(currTestList.get(i));
			}

			for (int i = 0; i < subjTestList.size(); i++) {
				boolean contTest = false;
				for (int j = 0; j < finalTestList.size(); j++)
					if (finalTestList.get(j).getTestId() == subjTestList.get(i)
							.getTestId()) {
						contTest = true;
					}

				if (!contTest)
					finalTestList.add(subjTestList.get(i));
			}
			String outputTable = "";
			for (int i = 0; i < finalTestList.size(); i++) {
				outputTable += Resource.getJspParams("param.select.tag1")
						+ TestSelector.getTestName(finalTestList.get(i)
								.getTestId())
						+ Resource.getJspParams("param.select.tag2") + i
						+ Resource.getJspParams("param.select.tag3") + i
						+ Resource.getJspParams("param.select.tag4") + "\n";
			}
			request.setAttribute(
					Resource.getJspParams("param.select.testtable"),
					outputTable);
			session.setAttribute(
					Resource.getJspParams("param.select.testIdList"),
					finalTestList);
			logger.info("test begins");
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