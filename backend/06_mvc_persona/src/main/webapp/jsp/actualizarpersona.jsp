<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Persona</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">

</head>
<body>

	<%@include file="../templates/banner_interno.html"%>


	<div>
		<a href="ListarPersonasController">Ir a Listar</a>
	</div>

	<div class="wrapper">
		<h1>Actualizar Persona</h1>

		<form method="post" action="ActualizarPersonaController">
			<input type="hidden" name="txtId" id="txtId" value="${persona.id}" />
			<br> <label for="txtId">Nombre</label> <input type="text"
				name="txtNombre" id="txtNombre" value="${persona.nombre}" /> <br>

			<label for="txtId">Clave</label> <input type="text" name="txtClave"
				id="txtClave" value="${persona.password}" /> <br> <br> <br>
			<input type="submit" value="Guardar" /> <br>
		</form>
	</div>


</body>
</html>