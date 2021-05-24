<%--
  Created by IntelliJ IDEA.
  User: CONG
  Date: 5/24/2021
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Classify: </td>
        <td>${product.getClassify()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.getPrice()}</td>
    </tr>
    <tr>
        <td>Describe: </td>
        <td>${product.getDescribe()}</td>
    </tr>
</table>
</body>
</html>