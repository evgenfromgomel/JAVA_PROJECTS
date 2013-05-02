<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="test.add.success" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="test.add.success" />
	</h3>
	<hr />

	<form name="finalTestForm" method="POST" action="controller">
		<input type="hidden" name="command" value="redirectcommand" />
		<input type="hidden" name="gotomainbutton" value="Go to main page" />
			<br /> <input type="submit" name="button"
			value="<tag:gettext key="button.go.to.main" />" />
	</form>



	<hr />
</body>
	</html>
