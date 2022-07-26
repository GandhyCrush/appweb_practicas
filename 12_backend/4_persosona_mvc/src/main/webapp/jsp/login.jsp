<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Persona</title>
</head>
<body>

<form method="post" action="../LoginController">
	<fieldset>
		<legend>Log in</legend>
		<p>Usuario:</p>
		<input type="text" name="usuario">
		<br>
		<p>Clave:</p>
		<input type="password" name="password">
		<br><br>
		<input type="submit" value="Ingresar">
	</fieldset>
</form>

</body>
</html>