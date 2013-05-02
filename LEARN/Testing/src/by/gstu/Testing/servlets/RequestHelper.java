package by.gstu.Testing.servlets;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.gstu.Testing.commands.AnswerQuestionCommand;
import by.gstu.Testing.commands.ChangeLangCommand;
import by.gstu.Testing.commands.CloseSessionCommand;
import by.gstu.Testing.commands.Command;
import by.gstu.Testing.commands.CreateParamsCommand;
import by.gstu.Testing.commands.CreateTestCommand;
import by.gstu.Testing.commands.FirstQuestionCommand;
import by.gstu.Testing.commands.LoginCommand;
import by.gstu.Testing.commands.NoCommand;
import by.gstu.Testing.commands.RedirectToMainCommand;
import by.gstu.Testing.commands.RegisterCommand;
import by.gstu.Testing.commands.SelectTestCommand;
import by.gstu.Testing.commands.SelectionParamsCommand;
import by.gstu.Testing.commands.ShowResultCommand;

public class RequestHelper {
	static Logger logger = Logger.getLogger(RequestHelper.class);
	private static RequestHelper instance = null;
	HashMap<String, Command> commands = new HashMap<String, Command>();

	private RequestHelper() {
		// filling table by commands
		commands.put("login", new LoginCommand());
		commands.put("register", new RegisterCommand());
		commands.put("createtest", new CreateTestCommand());
		commands.put("createparams", new CreateParamsCommand());
		commands.put("firstquestion", new FirstQuestionCommand());
		commands.put("answerquestion", new AnswerQuestionCommand());
		commands.put("selectparams", new SelectionParamsCommand());
		commands.put("selecttest", new SelectTestCommand());
		commands.put("redirectcommand", new RedirectToMainCommand());
		commands.put("showresult", new ShowResultCommand());
		commands.put("changelang", new ChangeLangCommand());
		commands.put("closesession", new CloseSessionCommand());
	}

	public Command getCommand(HttpServletRequest request) {
		// extracts command from request
		String action = request.getParameter("command");
		//getting object appropriate command
		Command command = commands.get(action);
		if (command == null) {
			// if command are not exist
			command = new NoCommand();
		}
		logger.info(command + "selected");
		return command;
	}

	// create object by pattern Singleton
	public static RequestHelper getInstance() {
		if (instance == null) {
			instance = new RequestHelper();
		}
		return instance;
	}
}