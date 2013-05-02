<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="title.test.list" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="title.test.list" />
	</h3>
	<hr />
	<form name="loginForm" method="POST" action="controller">
		<input type="hidden" name="command" value="selecttest" /> 
		<input type="hidden" name="confirmselection" value="Continue" /> 
		<tag:gettext key="text.select.subject" /><br /> <select name="subjectlist">
			<option value="1">
				<c:out value="${subj1}" />
			</option>
			<option value="2">
				<c:out value="${subj2}" />
			</option>
			<option value="3">
				<c:out value="${subj3}" />
			</option>
			<option value="4">
				<c:out value="${subj4}" />
			</option>
		</select><br /> <input type="submit" name="button" value="<tag:gettext key="text.select.button" />" />
	</form>
	<c:out value="${subject}"></c:out>
	<form name="creatorForm" method="POST" action="controller">
		<input type="hidden" name="command" value="firstquestion" />
		<input type="hidden" name="mainbutton" value="Start test" />
		<table border="1px" cellspacing="1px" align="center">
			<tr>
				<td><tag:gettext key="title.test.list" /></td>
				<td><tag:gettext key="hat.table.select" /></td>
			</tr>
			${testtable}
		</table>

		
		<div align="center"><input type="submit" name="button" value="<tag:gettext key="button.start.test" />" /></div>
	</form>

	<hr />
</body>
	</html>

