<%@ page import="Models.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: itripathi
  Date: 29-May-20
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>
<h1>You have <%=(int) session.getAttribute("cartSize")%> items <br>
    View your cart <a href="viewCart">here</a>
</h1>
<%!
    List<Product> products;
%>
<table border="1">
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Action</th>
    </tr>
    <%
        products= (List<Product>) session.getAttribute("productList");
        if(products!=null)
        for (Product p: products)
        {
    %>
        <tr>
            <form action="AddToCart" method="POST">
                <input type="hidden" name="productID" value="<%=p.getProductID()%>"/>
                <td> <%=p.getProductID() %> </td>
                <td> <%=p.getProductName() %> </td>
                <td> <%=p.getProductPrice() %> </td>
                <td> <input type="submit" value="Add to Cart"/></td>
            </form>
        </tr>
    <%
        }
    %>

    <br>
    <br>
    <h1> Visit cart <a href="" >here </a></h1>
</table>
</body>
</html>
