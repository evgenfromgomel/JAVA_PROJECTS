<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
<html>
<head>
<title><tag:gettext key="text.creation.test" />
</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3>
		<tag:gettext key="text.creation.test" />
	</h3>
	<hr />
	<form name="creatorForm" method="POST" action="controller">
		<input type="hidden" name="command" value="createtest" /> <input
			type="hidden" name="createbutton" value="Continue" />
		<div>
			<tag:gettext key="text.name.test" />
		</div>
		<input type="text" name="nametest" value="" /> <br />
		<tag:gettext key="text.select.subject" />
		<br /> <select name="subjectlist">
			<option disabled="">
				<c:out value="Select subject" />
			</option>
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
		</select><br /> <input type="submit" name="button"
			value="<tag:gettext key="text.select.button" />" />
	</form>
	<div align="center">${subject}</div>
	<form name="creatorForm" method="POST" action="controller">
		<input type="hidden" name="command" value="createtest" /> <input
			type="hidden" name="createbutton" value="Add test" />
		<table border="1px" cellspacing="1px" align="center">
			<tr>
				<td align="center"><tag:gettext key="hat.table.quest" />
				</td>
				<td align="center"><tag:gettext key="hat.table.select" />
				</td>
			</tr>
			${questtable}
		</table>
		<br />${checkingresult}
		<div align="center">
			<input type="${type}" name="button"
				value="<tag:gettext key="button.add.test" />" />
		</div>
	</form>
	<hr />
	<form name="finalTestForm" method="POST" action="controller">
		<input type="hidden" name="command" value="redirectcommand" /> <input
			type="hidden" name="gotomainbutton" value="Go to main page" /><br />
		<input type="submit" name="button"
			value="<tag:gettext key="button.go.to.main" />" />
	</form>
</body>
</html>

