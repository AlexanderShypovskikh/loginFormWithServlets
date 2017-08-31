<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form name="loginForm" action="loginServlet" method="POST">
      <fieldset>
      <div><input type="text" name="login"/></div>
      <div><input type="password" name="pass"/></div>
      <div><input type="submit" name="go" value="Login"></div>
      </fieldset>
    </form>
</body>
</html>