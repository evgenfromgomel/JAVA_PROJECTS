<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
  xmlns:c=http://java.sun.com/jsp/jstl/core 
version="2.0"> 
<jsp:directive.page contentType="text/html; 
charset=Utf-8" /> 
  <html><head><title>Welcome</title></head> 
  <body><h3>Welcome</h3> 
  <hr /> 
  <c:out value="${user}, Hello!"/> 
  <hr /> 
  <a href="controller">Return to login page</a> 
  </body></html> 
</jsp:root> 