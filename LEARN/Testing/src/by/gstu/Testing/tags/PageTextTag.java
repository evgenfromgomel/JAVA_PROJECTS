package by.gstu.Testing.tags;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import by.gstu.Testing.events.LanguageChangeListener;

/**
 * Implements user tag library
 *
 */
public class PageTextTag extends TagSupport {

	private String key;
	static Logger logger = Logger.getLogger(PageTextTag.class);
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int doStartTag() throws JspException {
		String language = (String) pageContext.getSession().getAttribute(
				"param.language");

		Locale locale;
		if (language != null) {
			locale = new Locale(language, language.toUpperCase());
		} else {
			locale = pageContext.getRequest().getLocale();
		}

		ResourceBundle resource = ResourceBundle.getBundle(
				"by.gstu.Testing.resource.pagestext", locale);
		JspWriter writer = pageContext.getOut();
		try {
			try {
				writer.print(new String(resource.getString(key).getBytes(
						"ISO-8859-1"), "UTF-8"));
			} catch (MissingResourceException ex) {
				logger.debug(ex);
				writer.print(resource.getString("resource.not.found"));
			}
		} catch (IOException ex) {

		}
		return SKIP_BODY;
	}
}
