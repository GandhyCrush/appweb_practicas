<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Mascotas</title>
</head>
<body>
	<h1>Bienvenido, ${propietario}</h1><br>
	
	<div class="wrapper">
		<table class="table">
				<tr>
					<td scope="col">Id</td>
					<td scope="col">Nombre</td>
					<td scope="col">Edad</td>
				</tr>
			</thead>

			<c:forEach items="${catalogo}" var="mascota">
				<tr>
					<td>${mascota.id}</td>
					<td>${mascota.nombre}</td>
					<td>${mascota.edad}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>