package by.gstu.Testing.commands;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gstu.Testing.resource.Resource;

/**
 * This class contain method for load main page, if corresponding button are pressed
 *
 */
public class RedirectToMainCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		String page = "";
		String gotomain = Resource.getJspParams("param.answer.gotomain");
		String gotomainButton = Resource.getJspParams("param.answer.gotomainbutton");
		HttpSession session = request.getSession();
		if (request.getParameter(gotomain).equals(gotomainButton)) {
         if(session.getAttribute("role").equals(
					Resource.getJspParams("param.usertype.tutor"))){
        	 page = Resource.getJspParams("tutor.main.page.path");
         }else
			page = Resource.getJspParams("student.main.page.path");
		}
		return page;
	}

}