<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="title.register" /><tag:gettext key="${usertypekey}" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="title.register" /><tag:gettext key="${usertypekey}" />
	</h3>
	<hr />
	<form name="loginForm" method="POST" action="controller">
		<input type="hidden" name="command" value="register" /> 
		<input type="hidden" name="regbutton" value="Register now!" /> 
		<input type="hidden" name="role" value="${usertype}" /> 
		<tag:gettext key="text.enter.login" /><br /> <input type="text" name="newlogin" value="" /><br /> 
		<tag:gettext key="text.enter.password" /><br /> <input type="password" name="newpassword" value="" /><br />
		<tag:gettext key="text.enter.lastname" /><br /> <input type="text" name="newlastname" value="" /><br />
		<tag:gettext key="text.enter.firstname" /><br /> <input type="text" name="newfirstname" value="" /><br />
		<tag:gettext key="text.enter.choose" /><tag:gettext key="${accesorylinekey}" />
		<br /> <select name="accesoryname">
			<option disabled="">
				<c:out value="Choose" /><tag:gettext key="${accesorylinekey}" />
			</option>
			<option value="aVar1">
				<c:out value="${accesoryVar1}" />
			</option>
			<option value="aVar2">
				<c:out value="${accesoryVar2}" />
			</option>
			<option value="aVar3">
				<c:out value="${accesoryVar3}" />
			</option>
			<option value="aVar4">
				<c:out value="${accesoryVar4}" />
			</option>
		</select> <br /> <input type="submit" name="button" value="<tag:gettext key="text.button.register.now" />" />
		<c:out value="${sucessreg}" />

	</form>
	<hr />
	<a href="controller" ><tag:gettext key="text.return.login" /></a>
			
</body>
	</html>
