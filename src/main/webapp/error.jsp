<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta content = "text/html" charset="UTF-8">
<title>error page</title>
</head>
<body>
	<h1> <c:out  value = "${pageContext.exception.message}"/></h1><br>
	
	<a href="index.jsp">Main page </a> <br>	
	
</body>
</html>