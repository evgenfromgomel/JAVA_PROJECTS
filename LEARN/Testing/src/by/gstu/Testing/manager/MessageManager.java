package by.gstu.Testing.manager;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import by.gstu.Testing.commands.CreateTestCommand;

/**
 * Class extracts info from file messages.properties
 *
 */
public class MessageManager {
	private static MessageManager instance;
	private ResourceBundle resourceBundle;
	static Logger logger = Logger.getLogger(MessageManager.class);
	public static final String loginErrorMessage = "error.message";
	public static final String servletExceptionErrorMessage = "error.servlet.exception";
	public static final String ioExceptionErrorMessage = "error.io.exception";
	public static final String notFoundPageError = "error.not.found";
	public static final String incorrectTutorSpecPass = "error.incorrect.spec";

	private MessageManager(){
	}
	
	public static MessageManager getInstance(Locale loc) {
		if (instance == null) {
			instance = new MessageManager();
			instance.resourceBundle = ResourceBundle
					.getBundle("by.gstu.Testing.resource.messages",loc);
		}
		return instance;
	}

	public String getProperty(String key) throws UnsupportedEncodingException {

		return new String(((String) resourceBundle.getObject(key)).getBytes(
		"ISO-8859-1"), "UTF-8");
	}
}