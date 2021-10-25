<%--
  Created by IntelliJ IDEA.
  User: Josue
  Date: 24/10/2021
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.tree.Expression_Tree.*" %>
<%@ page import="com.example.tree.Expression_Tree" %>
<html>

<head>
    <title>Datos Recopilados</title>
</head>

<body>

<%
    Expression_Tree ExpTr= new Expression_Tree();
    String cptrd = request.getParameter("Grabber");
    System.out.println(cptrd);
    ExpTr.organizeQS(cptrd);
%>

</body>
</html>
