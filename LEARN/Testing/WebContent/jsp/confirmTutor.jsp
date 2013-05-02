<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="text.button.login" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3><tag:gettext key="title.confirm.tutor.status" /></h3>
	<hr />
	<form name="confirmTutor" method="POST" action="controller">
		<input type="hidden" name="command" value="register" /> 
		<input type="hidden" name="regbutton" value="Continue as tutor" /> 
		<tag:gettext key="text.confirm.password" />
		<br /> <input
			type="password" name="specpass" value="" /> <input type="submit"
			name="buttonconf" value="<tag:gettext key="button.confirm.tutor.status" />"/>
	</form>
	<hr />
</body>
	</html>
