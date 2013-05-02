package by.gstu.Testing.commands;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gstu.Testing.resource.Resource;


/**
 * This class closes current session and return user to login page
 *
 */
public class CloseSessionCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		HttpSession session = request.getSession();
        session.invalidate();
		String page = Resource.getJspParams("login.page.path");
		return page;
	}
}