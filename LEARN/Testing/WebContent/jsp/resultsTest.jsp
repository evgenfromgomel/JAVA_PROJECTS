<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="text.result.test" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="text.result.test" />
	</h3>
	<hr />
	<form name="finalTestForm" method="POST" action="controller">
		<input type="hidden" name="command" value="redirectcommand" />
		<input type="hidden" name="gotomainbutton" value="Go to main page" />

		<table border="1px" cellspacing="1px" align="center">
		    ${resulttablehead}
			${currResult}
			<c:forEach var="currResults" items="${currResult}">
               <tr><td> ${currResults.idStudent} </td><td> ${currResults.testName} </td><td>${currResults.result}</td></tr>
            </c:forEach>
		</table>
		<br /> <input type="submit" name="button" value="<tag:gettext key="button.go.to.main" />" />
	</form>
	<hr />
</body>
	</html>

