<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.shypovskikh.model.Coffee" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coffee List</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>


 <section class="container" align="center">
    <div>
      <h1>Coffee assortment</h1>
        <table>
            <tr>
                <th></th>
            	<th>Name</th>
            	<th>Price</th>
           		<th>Quantity</th>
            </tr>
            <% List<Coffee> listCoffee = (ArrayList) request.getAttribute("listCoffee"); %>
            <% System.out.println("size = "+listCoffee.size()); %>
            <c:forEach var="list" items="${listCoffee}" >
             <tr>
            <td><input id="checkbox" type="checkbox"></td>
            <td>${list}</td>
            <td></td>
            <td><input type="text" ></td>
            </tr>
         </c:forEach>
           <tr>
           	 <td></td>
           	 <td></td>
           	 <td></td>
             <td><input type="submit" value="Order" class ="csubmit"></td>
           </tr>
         </table>
      </div>
  </section>
</body>
</html>