<%--
  Created by IntelliJ IDEA.
  User: Josue
  Date: 24/10/2021
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.tree.Expression_Tree" %>
<html>

<head>
    <title>Calculadora</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<body>
<form action="inf.jsp" method="post">

    <section>
        <img src="math.png" id="bg">
        <h2 id="text">Ingrese la expresion matematica</h2>
        <button>Enviar</button>
    </section>

    <label>
        <input type="text" name="Grabber" placeholder="Expresion matematica" id="expresion" re>
    </label>

</form>
</body>



<%
    Expression_Tree ExpTr= new Expression_Tree();
    String cptrd = request.getParameter("Grabber");
    System.out.println(cptrd);
    ExpTr.organizeQS(cptrd);
%>
</html>