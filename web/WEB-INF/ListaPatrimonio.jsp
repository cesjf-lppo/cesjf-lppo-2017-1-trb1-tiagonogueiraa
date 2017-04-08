<%-- 
    Document   : ListaPatrimonio
    Created on : 07/04/2017, 19:05:34
    Author     : tiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Patrimonio</title>
    </head>
    <body>
        <h1>Lista Patrimonio</h1>
	<table border="1">
	    <thead>
		<tr>
		    <th>Id</th>
		    <th>Serie</th>
		    <th>Local</th>
		    <th>Descricao</th>
		    <th>Estado</th>
		</tr>
	    </thead>
	    <c:forEach var="patrimonio" items="${patrimonio}">
		<tbody>
		    <tr>
			<td<a href="EditaPatrimonio.html?id=${patrimonio.id}">>${patrimonio.id}</td>
			<td>${patrimonio.serie}</td>
			<td>${patrimonio.local}</td>
			<td>${patrimonio.descricao}</td>
			<td>${patrimonio.estado}</td>
			<td><a href="ExcluiPatrimonio.html?id=${reclamacao.id}">X</td>
		</tbody>
	    </c:forEach>
	</table>


    </body>
</html>
