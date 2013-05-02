<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><c:out value=""></c:out></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<c:out value=""></c:out>
	</h3>
	<hr />
	<form name="loginForm" method="POST" action="controller">
		<input type="hidden" name="command" value="answerquestion" />
		<input type="hidden" name="answerbutton" value="Next" />
		<table border="1px" cellspacing="1px" align="center" width="50%">
			<tr name="textQuestion">
				<td><c:out value="${textquest}"></c:out>
				</td>
			</tr>

			<tr>
				<td><input type="radio" name="answer1" value="var1" />
				<c:out value="${variant1}"></c:out></td>
			</tr>
			<tr>
				<td><input type="radio" name="answer2" value="var2" />
				<c:out value="${variant2}"></c:out></td>
			</tr>
			<tr>
				<td><input type="radio" name="answer3" value="var3" />
				<c:out value="${variant3}"></c:out></td>
			</tr>
			<tr>
				<td><input type="radio" name="answer4" value="var4" />
				<c:out value="${variant4}"></c:out></td>
			</tr>

		</table>
		<div align="center">
			<input type="submit" name="button" value="<tag:gettext key="button.next" />" />
		</div>
		<hr />

	</form>
</body>
	</html>
