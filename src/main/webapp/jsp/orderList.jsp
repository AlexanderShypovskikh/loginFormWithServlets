<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.shypovskikh.model.User" %>
    <%@ page import="com.shypovskikh.model.Coffee" %>
    <%@ page import="com.shypovskikh.model.CoffeeOrderItem"%>
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
   <form action="order" method="POST">
      <table class="coffee-list-table" border ="3px" align="center" >  
        <caption> Delivery:</capation>
         <tr>
             <% User user = (User) request.getServletContext().getAttribute("user"); %>
           <td>Name</td><td><input type="text" name="name" value="<%=user.getFirstName() %>"/></td>
           <td>Address</td><td><input type="text" name="address" value="<%=user.getAddress() %>"/></td>
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
         
          
         <% List<Coffee> list  = (List)request.getServletContext().getAttribute("selectedList"); %>
         <% List<CoffeeOrderItem> item = (List) request.getServletContext().getAttribute("orderedList"); %>
             <% for (int i = 0; i < list.size(); i++) { %>
             <tr>
            <td><%=list.get(i).getTypeName()%> </td> 
            <td><%= list.get(i).getPrice() %> </td> 
            <td><%= item.get(i).getQuantity() %> </td>
            </tr>
            <% } %>
            <tr><td>Total:</td><td><%= request.getAttribute("cost") %></td></tr>
        
             </table>
     </div>
   </div>
</body>
</html>