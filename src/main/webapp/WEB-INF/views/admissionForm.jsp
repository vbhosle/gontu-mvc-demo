<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission</title>
</head>
<body>
	<h2>${headerMsg}</h2>
	<form action="/gontu-mvc-demo/submitAdmissionForm" method="POST">
		Student's name:<br> <input type="text" name="studentName"><br>
		Student's hobby:<br> <input type="text" name="studentHobby"><br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>