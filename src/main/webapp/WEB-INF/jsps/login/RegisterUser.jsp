<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User </title>
</head>
<body>
<H2>User Registration</H2>
<form action="RegisterUser" method="post">
<pre>
First Name: <input type = "text" name="firstName"/>
Last Name: <input type = "text" name="lastName"/>
User Name: <input type = "text" name="email"/>
password <input type = "password" name="password"/>
Confirm password <input type = "password" name="confirmPassword"/>
<input type = "submit" value="register"/>
</pre>
</form>
</body>
</html>