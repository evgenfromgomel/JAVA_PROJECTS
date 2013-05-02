package by.gstu.Testing.manager;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import by.gstu.Testing.commands.CreateTestCommand;

/**
 * @author evgen
 *
 */
public class TableHeadManager {
	private static TableHeadManager instance;
	private ResourceBundle resourceBundle;
	static Logger logger = Logger.getLogger(TableHeadManager.class);
	public static final String STUDENT_RESULT_TABLE_HEAD = "result.student.taghead";
	public static final String TUTOR_RESULT_TABLE_HEAD = "result.tutor.taghead";


	
	public static TableHeadManager getInstance(Locale loc) {
		if (instance == null) {
			logger.debug(loc);
			instance = new TableHeadManager();
			instance.resourceBundle = ResourceBundle
					.getBundle("by.gstu.Testing.resource.pagestext",loc);
		}
		return instance;
	}

	public String getProperty(String key) throws UnsupportedEncodingException {
        logger.debug(key);
		return (String) resourceBundle.getObject(key);
	}
}