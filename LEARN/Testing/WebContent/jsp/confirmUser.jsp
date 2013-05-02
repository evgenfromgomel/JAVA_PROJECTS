<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="title.confirm.status" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3><tag:gettext key="title.confirm.status" /></h3>
	<hr />
	<form name="goRegister" method="POST" action="controller">
		<input type="hidden" name="command" value="register" />
		<input type="hidden" name="regbutton" value="Continue register" /> 
		 <input
			type="radio" name="confirm" value="student" /><tag:gettext key="radio.select.student" />
			 <input
			type="radio" name="confirm" value="tutor" /><tag:gettext key="radio.select.tutor" />
			 <input type="submit" name="button" value="<tag:gettext key="text.select.button"/>"/>
		<hr />
	</form>
</body>
	</html>
