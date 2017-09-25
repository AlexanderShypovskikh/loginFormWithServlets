<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.shypovskikh.model.User" %>
<%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div>
     <div>
     </div>
   <div>
   <form action="" method="POST">
      <table class="coffee-list-table" border ="3px" align="center" >  
        <caption> Delivery:</capation>
         <tr>
             <% User user = (User) request.getServletContext().getAttribute("user"); %>
           <td>Name</td><td><%=user.getFirstName() %></td>
           <td>Address</td><td><%=user.getAddress() %></td>
           </tr>
           <tr>
              <td><input type="submit" value="Order"></td>
           </tr>
      </table>
      </form>
   </div>
   
     <div>
          <table class="coffee-list-table" align="center" border="3px">  
        <caption> Order:</caption>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th> 
         </tr>
           <% Map<String,String>coffee = (HashMap)request.getServletContext().getAttribute("coffeeMap"); %>
           <% System.out.println("map = "+coffee.toString()); %>
           <% Map<String,String>quantity = (HashMap)request.getServletContext().getAttribute("quantityMap"); %>
           <% Map<String,Double>price = (HashMap)request.getServletContext().getAttribute("priceMap"); %>
           <%Iterator iterCoffee = coffee.entrySet().iterator(); %>
           <%Iterator iterQuant =  quantity.entrySet().iterator(); %>
           <%Iterator iterPrice = price.entrySet().iterator(); %>
           
            <% for (Map.Entry<String, String> entry : coffee.entrySet()) { %>
             <tr><% String key = entry.getKey(); %>
             <% String value = entry.getValue(); %>
            <td><%=value%> </td> 
            <td><%= price.get(value) %> </td> 
            <td><%= quantity.get(value) %> </td>
            </tr>
            <% } %>
      </table>
     </div>
   </div>
</body>
</html>