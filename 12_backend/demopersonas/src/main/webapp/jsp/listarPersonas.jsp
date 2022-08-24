<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<body>


	<%@include file="../templates/banner_interno.html" %>


	<h1>Listado de Personas</h1>
	<div>
		<a href="InsertarPersonaController">Nuevo</a>
	</div>

	<div class="wrapper">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td scope="col">Id</td>
					<td scope="col">Nombre</td>
					<td scope="col">Clave</td>
					<td scope="col">Acciones</td>
				</tr>
			</thead>

			<c:forEach items="${personas}" var="persona">
				<tr>
					<td>${persona.id}</td>
					<td>${persona.nombre}</td>
					<td>${persona.clave}</td>
					<td><a
						href="ActualizarPersonaController?idPersona=${persona.id}">Actualizar</a>
						| <a href="EliminarPersonaController?idPersona=${persona.id}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>