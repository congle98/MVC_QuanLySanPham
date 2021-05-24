<%--
  Created by IntelliJ IDEA.
  User: CONG
  Date: 5/24/2021
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
            </tr>
            <tr>
                <td>Classify: </td>
                <td>
                    <select name="classify" id="classify" value="${product.getClassify()}">
                        <option value="Nong San">Nông Sản</option>
                        <option value="Thuy San">Thuỷ Sản</option>
                        <option value="Lam San">Lâm Sản</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${product.getPrice()}"></td>
            </tr>
            <tr>
                <td>Describe: </td>
                <td><input type="text" name="describe" id="describe" value="${product.getDescribe()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
