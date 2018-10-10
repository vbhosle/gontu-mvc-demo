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
		Student's mobile:<br> <input type="text" name="studentMobile"><br>
		Student's dob:<br> <input type="text" name="studentDOB"><br>
		Student's skills:<br> 
		<select name="studentSkills" multiple="multiple">
			<option value="Java">Java</option>
			<option value="Spring">Spring</option>
			<option value="Hibernate">Hibernate</option>
		</select>
		<br>
		<h4>Address</h4>
		Country:<input type="text" name="studentAddress.country"><br>
		City:<input type="text" name="studentAddress.city"><br>
		Street:<input type="text" name="studentAddress.street"><br>
		PinCode:<input type="number" name="studentAddress.pincode"><br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>