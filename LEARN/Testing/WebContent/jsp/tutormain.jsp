<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="title.tutor.page" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="title.tutor.page" />
	</h3>
	<hr />
	<form name="createTest" method="POST" action="controller">
		<input type="hidden" name="command" value="createparams" />
		<input type="hidden" name="redirbutton" value="Create test" /> 
		 <input
			type="submit" name="button" value="<tag:gettext key="button.test.create" />" />
	</form>
	<form name="showResult" method="POST" action="controller">
		<input type="hidden" name="command" value="showresult" />
		<input type="hidden" name="mainbutton" value="Show students results" />
		 <input
			type="submit" name="button" value="<tag:gettext key="button.show.results.all" />" />
	</form>
			<form name="showResult" method="POST" action="controller">
		<input type="hidden" name="command" value="closesession" />
		 <input
			type="submit" name="button" value="<tag:gettext key="button.closession" />" />
	</form>
	<hr />
</body>
	</html>

