<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Demo</title>
</head>
<body>
	<h2>${headerMsg}</h2>
	<p>Student name: ${studentDetails.studentName}</p>
	<p>Student hobby: ${studentDetails.studentHobby}</p>
	<p>Student Mobile: ${studentDetails.studentMobile}</p>
	<p>Student DOB: ${studentDetails.studentDOB}</p>
	<p>Student Skills: ${studentDetails.studentSkills}</p>
</body>
</html>