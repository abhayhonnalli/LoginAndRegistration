<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
</head>
<body>
	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<h3>This is Admin Module</h3>
	
	
	<a href="UserController">Detials</a><br> 
   <c:forEach var="user" items="${users}">
   <br>
   <c:out value="${user}"></c:out>
   
   
   
   </c:forEach>
	
</body>
</html>