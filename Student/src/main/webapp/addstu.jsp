<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<title>spring boot</title>
</head>
<body>Enter Student Details...
<form action="/addstudent" method="post">
Enter id:
<input type="text" name="id" id="id">
<br>
Enter name:
<input type="text" name="name" id="name">
<br>
Enter mark:
<input type="text" name="marks" id="marks">
<br>
Enter result:
<input type="text" name="result" id="result">
<br>
<input type="submit" value="submit">
</form>


</body>
</html>