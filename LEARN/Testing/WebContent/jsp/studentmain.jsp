<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="title.student.main" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="title.student.main" />
	</h3>
	<hr />
	<form name="goTestList" method="POST" action="controller">
		<input type="hidden" name="command" value="selectparams" /> 
		<input type="hidden" name="mainbutton" value="Show tests list" />
		<input
			type="submit" name="button" value="<tag:gettext key="button.show.tests" />" />
	</form>
	<form name="showResult" method="POST" action="controller">
		<input type="hidden" name="command" value="showresult" />
		<input type="hidden" name="mainbutton" value="Show my results"" />
		 <input
			type="submit" name="button" value="<tag:gettext key="button.show.results.my" />" />
	</form>
		<form name="showResult" method="POST" action="controller">
		<input type="hidden" name="command" value="closesession" />
		 <input
			type="submit" name="button" value="<tag:gettext key="button.closession" />" />
	</form>
	<hr />
</body>
	</html>
