<%@ page language="java" contentType="text/html; 
   charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/testingtaglib.tld" prefix="tag"%>
	<html>
<head>
<title><tag:gettext key="title.text.error" /></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h3 ><tag:gettext key="title.text.error" /></h3>
	<hr />
          <tag:gettext key="${errormessage}" />
	<hr />
	<a href="controller"><tag:gettext key="text.return.login" /></a>

</body>
	</html>
