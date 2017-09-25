<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
   <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  <script src="js/script.js"></script>
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Internet Coffee Shop</h1>
      <form name="loginForm" method="POST" action="getCoffee" onsubmit="return validateForm()">
        <p><input type="text" name="login" value="" placeholder="Email"></p>
        <sub id="loginErr" class="error"></sub>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <sub id="passwordErr" class="error"></sub>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
       <p class="submit"><sub class="registration"><a href="jsp/registration.jsp">not registered? register now</a></sub></p>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </div>
  </section>
  </body>
</html>