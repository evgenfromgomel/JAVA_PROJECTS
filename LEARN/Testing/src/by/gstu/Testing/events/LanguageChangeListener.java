package by.gstu.Testing.events;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import org.apache.log4j.Logger;



/**
 * This class listens events of language changing 
 *
 */
public class LanguageChangeListener implements HttpSessionAttributeListener {
	static Logger logger = Logger.getLogger(LanguageChangeListener.class);
	private String language = "param.language";
	private String english = "en";
	private String russian = "ru";

	public void attributeAdded(HttpSessionBindingEvent ev) {
		HttpSession session = ev.getSession();
		String currentAttributeName = ev.getName();
		if (currentAttributeName.equals(language))
			logger.debug("language change on "+language);

	}

	public void attributeRemoved(HttpSessionBindingEvent ev) {
	}

	public void attributeReplaced(HttpSessionBindingEvent ev) {
		String currentAttributeName = ev.getName();
		HttpSession session = ev.getSession();
		if (currentAttributeName.equals(language))
			if (((String) ev.getValue()).equals(english)) {
				System.out.print("language change on english");
			} else if (((String) ev.getValue()).equals(russian)) {
				System.out.print("language changed on russian");
			}

	}
}