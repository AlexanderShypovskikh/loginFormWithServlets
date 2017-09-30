<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.shypovskikh.model.Coffee" %>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coffee List</title>
 <!-- <link rel="stylesheet" href="css/style.css"> --> 
    <script src="js/script.js"></script>
</head>
<body>


 <section class="" align="center">
    <div>
      <h1 align="center" >Coffee assortment</h1>
        <form action="confirmOrder" method="POST">
        <table border="2px">
            <tr>
                <th></th>
            	<th>Name</th>
            	<th>Price</th>
           		<th>Quantity</th>
            </tr>
            
            <% List<Coffee> listCoffee = (ArrayList) request.getServletContext().getAttribute("listCoffee"); %>
            <% System.out.println("size = "+listCoffee.size()); %>
            <%! int i = 0;%>
           <c:forEach items = "${listCoffee}"  var = "coffee">
             <% i++; %>
            <tr>
            <td><input  type="checkbox" name="checkbox" value="<%=i%>" > </td>
            <td id="name_type"> <c:out value = "${coffee.getTypeName()}"/></td>
            <td id ><c:out value = "${coffee.getPrice()}"/></td>
            <input type="hidden" name="price<%= i %>" value="${coffee.getPrice()}">
            <td><input type="number" name="quantity" class="coffee_count" size="3" min="null" max="100" maxlength="3"></td>
            </tr>
         </c:forEach>
           <tr>
           	 <td></td>
           	 <td></td>
           	 <td></td>
             <td><input type="submit" value="Order" class ="csubmit"></td>
           </tr>
         </table>
         </form>
      </div>
  </section>
</body>
</html>