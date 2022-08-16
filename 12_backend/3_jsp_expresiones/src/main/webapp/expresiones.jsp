<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="index.html">Enlace a Inicio</a>
	<%= "Es una concatenación" + " de prueba " + "En JSP" %>
	<h1>Operaciones</h1>
	<%=10*2/2 %>
	<h1>Objetos implícitos</h1>
	<%= session.getId() %>
</body>
</html>