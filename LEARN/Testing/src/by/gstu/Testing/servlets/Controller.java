package by.gstu.Testing.servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.gstu.Testing.commands.Command;
import by.gstu.Testing.logic.LocaleReader;
import by.gstu.Testing.manager.MessageManager;
import by.gstu.Testing.mysqlImplementsDAO.MysqlTestDAO;
import by.gstu.Testing.resource.Resource;

public class Controller extends HttpServlet implements javax.servlet.Servlet {
	/**
	 * Class of servlet Controller
	 */
	static Logger logger = Logger.getLogger(Controller.class);
	private static final long serialVersionUID = 2225524611273301461L;
	//object contains commands list
	RequestHelper requestHelper = RequestHelper.getInstance();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		String page = null;
		try {
			// determinate command requested from JSP
			Command command = requestHelper.getCommand(request);
			/*
			 * calling realized method execute() of interface Command 
			 * and set parameters for necessary class-processor
			 */
			page = command.execute(request, response);
			// method returns answer page
		} catch (ServletException e) {
			e.printStackTrace();
			// generate error message
			Locale locale = LocaleReader.getLocale(request);
			request.setAttribute(
					"errormessage",
					MessageManager.getInstance(locale).getProperty(
							MessageManager.servletExceptionErrorMessage));
			// calling JSP-page with error message
			page = Resource.getJspParams("error.page.path");
		} catch (IOException e) {
			e.printStackTrace();
		    Locale locale = LocaleReader.getLocale(request);
			request.setAttribute(
					"errormessage",
					MessageManager.getInstance(locale).getProperty(
							MessageManager.ioExceptionErrorMessage));
			page = Resource.getJspParams("error.page.path");
		}
		// calling answer request page
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}