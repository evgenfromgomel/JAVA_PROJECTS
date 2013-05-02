package by.gstu.Testing.logic;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;

public class LocaleReader {

	public static Locale getLocale(HttpServletRequest request) {
		String language = (String) request.getSession().getAttribute(
				"param.language");
		Locale locale;
		if (language != null) {
			locale = new Locale(language, language.toUpperCase());
		} else {
			locale = Locale.getDefault();
		}
		return locale;
	}
}
