package by.gstu.Testing.filters;

import java.io.IOException;
import javax.servlet.*;

import org.apache.log4j.Logger;

import by.gstu.Testing.events.LanguageChangeListener;

/**
 * Class implements interface Filer and implement its method doFilter() witch 
 * set necessary encoding
 */
public class SetCharFilter implements Filter {
	private FilterConfig filterConfig = null;	
	static Logger logger = Logger.getLogger(SetCharFilter.class);
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain next) throws IOException, ServletException {
		// reading request encoding
		String encoding = request.getCharacterEncoding();
		logger.info(encoding);
		// set UTF-8 if one are not setted
		if (!"UTF-8".equalsIgnoreCase(encoding))
			request.setCharacterEncoding("UTF-8");
		next.doFilter(request, response);
	}

	public void destroy() {
	}
	

	
}