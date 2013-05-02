<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
<html>
<head>
<title><tag:gettext key="title.login.page" />
</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div align="left">
		<h3>
			<tag:gettext key="title.login.page" />
		</h3>
	</div>
	<div align="right">
		<table border="1px">
			<tr>
				<td><a href="controller?command=changelang&language=en">English</a>
				</td>
			</tr>
			<tr>
				<td><a href="controller?command=changelang&language=ru">Русский</a>
				</td>
			</tr>
		</table>
	</div>
	<hr />
	<form name="loginForm" method="POST" action="controller">
		<input type="hidden" name="command" value="login" />
		<tag:gettext key="login.page.login" />
		<br /> <input type="text" name="login" value=""><br />
		<tag:gettext key="login.page.password" />
		<br /> <input type="password" name="password" value=""> <br />
		<input type="submit" value="<tag:gettext key="text.button.login" />">

	</form>
	<form name="goRegister" method="GET" action="controller">
		<input type="hidden" name="command" value="register" />
			<input type="hidden" name="regbutton" value="Register" />
		 <input type="submit" name="button" value="<tag:gettext key="text.button.register"/>" />
	</form>
	<hr />
</body>
</html>
