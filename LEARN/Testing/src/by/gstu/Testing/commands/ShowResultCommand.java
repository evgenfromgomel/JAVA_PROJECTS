package by.gstu.Testing.commands;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gstu.Testing.entities.Result;
import by.gstu.Testing.entities.Student;
import by.gstu.Testing.logic.LocaleReader;
import by.gstu.Testing.logic.ResultManager;
import by.gstu.Testing.manager.MessageManager;
import by.gstu.Testing.manager.TableHeadManager;
import by.gstu.Testing.resource.Resource;

/**
 * This class show results of students
 *
 */
public class ShowResultCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			UnsupportedEncodingException, ClassNotFoundException {
		String page = "";
		String outputTable = "";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("role").equals(
				Resource.getJspParams("param.usertype.tutor"))) {

			List<Result> currResults = ResultManager.getAllResults();
			Locale locale = LocaleReader.getLocale(request);
			String headTable = new String(TableHeadManager.getInstance(locale).getProperty(
					TableHeadManager.TUTOR_RESULT_TABLE_HEAD).getBytes(
					"ISO-8859-1"), "UTF-8");
		/*	for (int i = 0; i < currResults.size(); i++) {

				outputTable += Resource.getJspParams("general.tag1")
						+ ResultManager.getStudentName(currResults.get(i)
								.getIdStudent())
						+ Resource.getJspParams("general.tag2")
						+ ResultManager.getTestName(currResults.get(i)
								.getIdTest())
						+ Resource.getJspParams("general.tag2")
						+ Math.round(currResults.get(i).getResult())
						+ Resource.getJspParams("general.tag3") + "\n";
			}*/
			request.setAttribute("resulttablehead",
					headTable);
			request.setAttribute(Resource.getJspParams("result.currresult"),
					currResults);
		} else if (session.getAttribute("role").equals(
				Resource.getJspParams("param.usertype.student"))) {
			Student currStudent = (Student) session.getAttribute(Resource
					.getJspParams("login.current.user"));

			List<Result> currResults = ResultManager
					.getStudentResults(currStudent.getStudentId());
			Locale locale = LocaleReader.getLocale(request);
			String headTable = new String(TableHeadManager.getInstance(locale).getProperty(
							TableHeadManager.STUDENT_RESULT_TABLE_HEAD).getBytes(
							"ISO-8859-1"), "UTF-8");
			for (int i = 0; i < currResults.size(); i++) {

				outputTable += Resource.getJspParams("general.tag1")
						+ ResultManager.getTestName(currResults.get(i)
								.getIdTest())
						+ Resource.getJspParams("general.tag2")
						+ Math.round(currResults.get(i).getResult())
						+ Resource.getJspParams("general.tag3") + "\n";
			}
			request.setAttribute("resulttablehead",
					headTable);
			request.setAttribute(Resource.getJspParams("result.resulttable"),
					outputTable);
		}

		request.setAttribute(Resource.getJspParams("result.resulttable"),
				outputTable);
		page = Resource.getJspParams("result.page.path");
		return page;
	}

}