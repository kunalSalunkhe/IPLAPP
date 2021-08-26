<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Add New Match :

	<form:form action="addMatch" modelAttribute="match">

        Match Date : <form:input path="matchDate" />

		<br>
		<br>

       	Venue : <form:input path="venue" />

		<br>
		<br>
		
		Season Id : <form:input path="season.seasonId" />

		<br>
		<br>


		<input type="submit" value="submit" />


	</form:form>

</body>
</html>