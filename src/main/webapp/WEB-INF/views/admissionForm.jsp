<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission</title>
</head>
<body>
	<h2>${headerMsg}</h2>
	<h3><spring:message code="label.admissionForm" /></h3>
	<form:errors path="studentDetails.*"/>
	<form action="/gontu-mvc-demo/submitAdmissionForm" method="POST">
		<spring:message code="label.studentName" />:<br> <input type="text" name="studentName"><br>
		<spring:message code="label.studentHobby" />:<br> <input type="text" name="studentHobby"><br>
		<spring:message code="label.studentMobile" />:<br> <input type="text" name="studentMobile"><br>
		<spring:message code="label.studentDOB" />:<br> <input type="text" name="studentDOB"><br>
		<spring:message code="label.studentSkills" />:<br> 
		<select name="studentSkills" multiple="multiple">
			<option value="Java">Java</option>
			<option value="Spring">Spring</option>
			<option value="Hibernate">Hibernate</option>
		</select>
		<br>
		<h4><spring:message code="label.studentAddress" /></h4>
		<spring:message code="label.country" />:<input type="text" name="studentAddress.country"><br>
		<spring:message code="label.city" />:<input type="text" name="studentAddress.city"><br>
		<spring:message code="label.street" />:<input type="text" name="studentAddress.street"><br>
		<spring:message code="label.pincode" />:<input type="number" name="studentAddress.pincode"><br>
		<button type="submit"><spring:message code="label.submit" /></button>
	</form>
</body>
</html>