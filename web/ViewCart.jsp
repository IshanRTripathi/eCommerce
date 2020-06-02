<%@ page import="Models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Database.ProductDAO" %><%--
  Created by IntelliJ IDEA.
  User: itripathi
  Date: 31-May-20
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Cart</title>
</head>
<body>
<%!
    List<Product> products;
    ProductDAO productDAO;
%>
<table border="1">
    <tr>
        <th>Order ID</th>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Remove Item</th>
    </tr>
    <%
//    productDAO= (ProductDAO) session.getAttribute("productdao");
    products= (List<Product>) session.getAttribute("cartItems");
    if(products!=null)
    for (Product p: products)
    {
    %>
    <tr>
        <form action="AddToCart" method="POST">
            <input type="hidden" name="productID" value="<%=p.getProductID()%>"/>
            <td> <%=new ProductDAO().getProductID(p) %> </td>
            <td> <%=p.getProductID() %> </td>
            <td> <%=p.getProductName() %> </td>
            <td> <%=p.getProductPrice() %> </td>
            <td><input type="button" value="Remove Item"></td>
        </form>
    </tr>
        <%
        }
    %>
    <h5>total cart value <%= new ProductDAO().getTotalPrice() %></h5>
    <input align="bottom" type="submit" value="Make payment"/>
</body>
</html>
