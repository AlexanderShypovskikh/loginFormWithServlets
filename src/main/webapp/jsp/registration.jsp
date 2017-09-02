<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="..//css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  <script src="..//js/script.js"></script>
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Registration Form</h1>
      <form name="registerForm" method="POST" action="registration" onsubmit="return validateRegisterForm()">
        <p><input type="text" name="login" value="" placeholder="Email" size="15"></p>
        <sub id="loginErr" class="error"></sub>
        <p><input type="text" name="fname" value="" placeholder="First Name" size="15"></p>
        <sub id="fnameErr" class="error"></sub>
        <p><input type="text" name="lname" value="" placeholder="Last Name" size="15"></p>
        <sub id="lnameErr" class="error"></sub>
        <p><input type="password" name="password" value="" placeholder="Password" size="15"></p>
        <sub id="passwordErr" class="error"></sub>
        <p class="submit"><input type="submit" name="commit" value="Register" size="15"></p>
      </form>
      </div>
      </section>
</body>
</html>