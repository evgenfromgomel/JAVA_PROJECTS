package by.gstu.Testing.commands;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.gstu.Testing.logic.LocaleReader;
import by.gstu.Testing.logic.Registration;
import by.gstu.Testing.manager.MessageManager;
import by.gstu.Testing.resource.Resource;


/**
 * This class determines type user and if it necessary request password
 * for status confirmation. After that class provide logic for registration new user
 */
public class RegisterCommand implements Command {
	static Logger logger = Logger.getLogger(RegisterCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			UnsupportedEncodingException, ClassNotFoundException {
		String page = "";
		String regbutton = Resource.getJspParams("param.name.regbutton");
		String register = Resource.getJspParams("param.name.register");
		String regnow = Resource.getJspParams("param.name.regnow");
		String continueButton = Resource.getJspParams("param.name.tutor.continue");
		if (request.getParameter(regbutton).equals(register)) {
			page = Resource.getJspParams("register.conf.page.path");
		} else if (request.getParameter(regbutton).equals(continueButton)) {
			String inputPass = request.getParameter(Resource
					.getJspParams("param.name.specpass"));
			if (inputPass.equals(Resource
					.getJspParams("param.name.tutor.pass"))) {

				request.setAttribute(
						Resource.getJspParams("param.register.accesorylinekey"),
						Resource.getJspParams("param.register.accesorylinekey.post"));

				request.setAttribute(
						Resource.getJspParams("param.register.usertypekey"),
						Resource.getJspParams("param.register.usertypekey.tutor"));

				request.setAttribute(Resource
						.getJspParams("param.register.usertype"), Resource
						.getJspParams("param.register.usertype.tutor"));

				request.setAttribute(Resource
						.getJspParams("param.register.accessline"), Resource
						.getJspParams("param.register.accessline.tutor"));

				request.setAttribute(
						Resource.getJspParams("param.register.accesoryvar1"),
						new String(Resource.getJspParams(
								"param.register.accesoryvar1.tutor").getBytes(
								"ISO-8859-1"), "UTF-8"));

				request.setAttribute(
						Resource.getJspParams("param.register.accesoryvar2"),
						new String(Resource.getJspParams(
								"param.register.accesoryvar2.tutor").getBytes(
								"ISO-8859-1"), "UTF-8"));

				request.setAttribute(
						Resource.getJspParams("param.register.accesoryvar3"),
						new String(Resource.getJspParams(
								"param.register.accesoryvar3.tutor").getBytes(
								"ISO-8859-1"), "UTF-8"));

				request.setAttribute(
						Resource.getJspParams("param.register.accesoryvar4"),
						new String(Resource.getJspParams(
								"param.register.accesoryvar4.tutor").getBytes(
								"ISO-8859-1"), "UTF-8"));
				page = Resource.getJspParams("register.page.path");
			} else {
				Locale locale = LocaleReader.getLocale(request);
				request.setAttribute(
						"errormessage",
						MessageManager
								.getInstance(locale)
								.getProperty(
										MessageManager.incorrectTutorSpecPass));
				page = Resource.getJspParams("error.page.path");
			}
		} else if (request.getParameter(regbutton).equals(regnow)) {
			if (Registration.addUser(request.getParameter(Resource
					.getJspParams("param.register.newlogin")), request
					.getParameter(Resource
							.getJspParams("param.register.newpassword")),
					request.getParameter(Resource
							.getJspParams("param.register.newlastname")),
					request.getParameter(Resource
							.getJspParams("param.register.newfirstname")),
					request.getParameter(Resource
							.getJspParams("param.register.accesoryname")),
					request.getParameter(Resource
							.getJspParams("param.register.role")))) {
				request.setAttribute(Resource
						.getJspParams("param.register.succesreg"), Resource
						.getJspParams("param.register.succesreg.text"));
				logger.info("New user registered!");
				page = Resource.getJspParams("register.page.path");
			}
		} else if (isTutor(request)) {
			page = Resource.getJspParams("register.conftutor.page.path");
		} else if (!isTutor(request)) {

			request.setAttribute(
					Resource.getJspParams("param.register.accesorylinekey"),
					Resource.getJspParams("param.register.accesorylinekey.group"));

			request.setAttribute(Resource
					.getJspParams("param.register.usertypekey"), Resource
					.getJspParams("param.register.usertypekey.student"));

			request.setAttribute(
					Resource.getJspParams("param.register.usertype"),
					Resource.getJspParams("param.register.usertype.student"));

			request.setAttribute(Resource
					.getJspParams("param.register.accessline"), Resource
					.getJspParams("param.register.accessline.student"));

			request.setAttribute(
					Resource.getJspParams("param.register.accesoryvar1"),
					new String(Resource.getJspParams(
							"param.register.accesoryvar1.student").getBytes(
							"ISO-8859-1"), "UTF-8"));

			request.setAttribute(
					Resource.getJspParams("param.register.accesoryvar2"),
					new String(Resource.getJspParams(
							"param.register.accesoryvar2.student").getBytes(
							"ISO-8859-1"), "UTF-8"));

			request.setAttribute(
					Resource.getJspParams("param.register.accesoryvar3"),
					new String(Resource.getJspParams(
							"param.register.accesoryvar3.student").getBytes(
							"ISO-8859-1"), "UTF-8"));

			request.setAttribute(
					Resource.getJspParams("param.register.accesoryvar4"),
					new String(Resource.getJspParams(
							"param.register.accesoryvar4.student").getBytes(
							"ISO-8859-1"), "UTF-8"));
			page = Resource.getJspParams("register.page.path");
		} else {
			Locale locale = LocaleReader.getLocale(request);
			request.setAttribute(
					"errormessage",
					MessageManager.getInstance(locale)
							.getProperty(MessageManager.notFoundPageError));
			page = Resource.getJspParams("error.page.path");

		}
		return page;
	}

	private boolean isTutor(HttpServletRequest request) {
		boolean tempFlag = false;
		if (request
				.getParameter(Resource.getJspParams("param.name.confirm"))
				.equals(Resource.getJspParams("param.name.tutor"))) {
			tempFlag = true;
		}
		return tempFlag;
	}
}