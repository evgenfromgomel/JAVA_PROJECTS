package by.gstu.Testing.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import by.gstu.Testing.resource.Resource;


/**
 *  This class contain method for change language of pages and writes current
 *  language in session. Also info about changing adds to log file.
 */
public class ChangeLangCommand implements Command {
	static Logger logger = Logger.getLogger(ChangeLangCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		String page = "";
		HttpSession session = request.getSession();
		String newLang = (String) request.getParameter("language");
		String lastAddr = (String) session.getAttribute("current.addres");
		session.setAttribute("param.language", newLang);
		if (lastAddr != null) {
			page = lastAddr;
		} else
			page = Resource.getJspParams("login.page.path");
		logger.info("language changed" + newLang);
		return page;
	}
}