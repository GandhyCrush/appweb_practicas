<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Persona</title>

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

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Gestor de Personas</span>
		</div>

	</nav>


	<div class="wrapper">
		<div class="formContent">
			<form method="post" action="LoginController">
				<fieldset>
					<legend>Log in</legend>
					<p>Usuario</p>
					<input type="text" name="usuario" />
					<p>Clave</p>
					<input type="password" name="password" /> <br> <br> <br>
					<input type="submit" value="Ingresr" />
				</fieldset>
			</form>
		</div>

	</div>
</body>
</html>