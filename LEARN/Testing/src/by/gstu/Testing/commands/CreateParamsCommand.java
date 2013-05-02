package by.gstu.Testing.commands;

//import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.gstu.Testing.logic.ReadSubjects;
import by.gstu.Testing.resource.Resource;

/**
 * This class prepare information for test creation. Here user must select subject, 
 * on which test will be create
 */
public class CreateParamsCommand implements Command {
	static Logger logger = Logger.getLogger(CreateParamsCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ClassNotFoundException {
		String page = "";
		
		String redirButton = request.getParameter(
				Resource.getJspParams("param.testcreate.redirbutton"));
		String createTestButton = Resource.getJspParams("param.testcreate");
		if (redirButton.equals(createTestButton)) {
			
			String type = Resource.getJspParams("param.testcreate.type");
			String hidden = Resource.getJspParams("param.testcreate.hidden");
			request.setAttribute(type, hidden);
			
			String visible = Resource.getJspParams("param.testcreate.visible");
			String typeTrue = Resource.getJspParams("param.testcreate.true");
			request.setAttribute(visible,typeTrue);
			
			String[] arrSubjs = ReadSubjects.getSubjArray();
			for (int i = 1; i < 5; i++){
				String subject = Resource.getJspParams("param.testcreate.subj" + i);
				request.setAttribute(subject,arrSubjs[i - 1]);
			}
			page = Resource.getJspParams("test.creation.path");
			logger.info("test creating begins");
		}

		return page;
	}

}