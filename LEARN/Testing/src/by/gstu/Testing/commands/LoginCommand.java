package by.gstu.Testing.commands;

import java.io.IOException;
import java.util.Locale;

import by.gstu.Testing.entities.Student;
import by.gstu.Testing.entities.Tutor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import by.gstu.Testing.logic.Authorization;
import by.gstu.Testing.manager.MessageManager;
import by.gstu.Testing.resource.*;

/**
 * This class provide logic for loggining user.
 *
 */
public class LoginCommand implements Command {
	static Logger logger = Logger.getLogger(LoginCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

		String page = null;
		// get login and password from request
		String login = request.getParameter(Resource
				.getJspParams("param.name.login"));
		String pass = request.getParameter(Resource
				.getJspParams("param.name.password"));

		// login and password cheking
		if (Authorization.checkLogin(login, pass)) {
			String role = "";
			HttpSession currentSession = request.getSession(true);
			Object unknowUser = Authorization.getUser(login, pass);
			if (unknowUser.getClass().equals(Student.class)) {
				Student studentUser = (Student) unknowUser;
				currentSession.setAttribute(
						Resource.getJspParams("login.current.user"),
						studentUser);
				logger.info("student" + studentUser.getLastName()
						+ studentUser.getFirstName() + "logined");
				role = studentUser.getRole();
			} else if (unknowUser.getClass().equals(Tutor.class)) {
				Tutor tutorUser = (Tutor) unknowUser;
				currentSession.setAttribute(
						Resource.getJspParams("login.current.user"), tutorUser);
				logger.info("tutor" + tutorUser.getLastName()
						+ tutorUser.getFirstName() + "logined");
				role = tutorUser.getRole();
			}

			currentSession.setAttribute("role", role);
			// currentSession.setAttribute("param.language",
			// ((String)request.getAttribute("param.language")));
			
			if (currentSession.getAttribute("role").equals(
					Resource.getJspParams("param.usertype.tutor"))) {
				page = Resource.getJspParams("tutor.main.page.path");
			} else if (currentSession.getAttribute("role").equals(
					Resource.getJspParams("param.usertype.student"))) {
				page = Resource.getJspParams("student.main.page.path");

			}
		} else {
			String language = (String) request.getSession().getAttribute(
					"param.language");
			Locale locale;
			if (language != null) {
				locale = new Locale(language, language.toUpperCase());
			} else {
				locale = Locale.getDefault();
			}

			request.setAttribute(
					"errormessage",
					new String(MessageManager.getInstance(locale).getProperty(
							MessageManager.loginErrorMessage).getBytes(
							"ISO-8859-1"), "UTF-8"));
			page = Resource.getJspParams("error.page.path");
		}

		return page;
	}
}