package by.gstu.Testing.commands;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gstu.Testing.resource.Resource;

/**
 * If browser request controller directly this class load necessary page 
 *
 */
public class NoCommand implements Command {

	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		HttpSession session = request.getSession(true);

		String page = Resource.getJspParams("login.page.path");
		session.setAttribute("current.addres", page);
		return page;
	}
}