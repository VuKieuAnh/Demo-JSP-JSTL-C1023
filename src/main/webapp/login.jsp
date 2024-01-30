<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 30/01/2024
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Xin chào</h1>
String name = "KA";
<%--Expressions: <%= Expressions%>--%>
<%--• Scriptlets: <% Code%>--%>
<%--• Declarations: <%!Declarations%>--%>

<h2>
  <%
    String name = request.getParameter("ten");
    out.print(name);
  %>
</h2>
</body>
</html>
