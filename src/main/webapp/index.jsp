<%@ page import="java.util.List" %>
<%@ page import="org.example.demo2.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="ka" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%


    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer("Huynh Tran Thanh Dung", "1/2/2000", "Da Nang", "data:image/jpeg;base64,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"));
    customers.add(new Customer("Le Dang Phap", "12/4/2001", "Da Nang"));
    customers.add(new Customer("Nguyen Van Anh", "12/4/2001", "Hue"));

    request.setAttribute("khachhang", customers);

    out.print(customers.size());
%>
<table border="1px">
    <tr>
        <td>Ten</td>
        <td>Ngay sinh</td>
        <td>Dia chi</td>
        <td>Anh</td>
    </tr>
    <ka:forEach var="kh" items="${khachhang}" >
        <tr>
            <td>${kh.name}</td>
            <td>${kh.dateOfBirth}</td>
            <td>${kh.address}</td>
            <td>
                <img src="${kh.img}">
            </td>
        </tr>
    </ka:forEach>
</table>
</body>
</html>