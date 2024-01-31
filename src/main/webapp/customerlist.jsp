<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 31/01/2024
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach khach hang</h1>
<table border="1px">
  <tr>
    <td>Ten</td>
    <td>Ngay sinh</td>
    <td>Dia chi</td>
<%--    <td>Anh</td>--%>
  </tr>
  <c:forEach var="customer" items="${kh}">
    <tr>
      <td>${customer.name}</td>
      <td>${customer.dateOfBirth}</td>

      <td>${customer.address}</td>
    </tr>
  </c:forEach>

</table>
</body>
</html>
