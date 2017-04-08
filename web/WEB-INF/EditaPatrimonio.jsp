<%-- 
    Document   : NovoPatrimonio
    Created on : 07/04/2017, 10:27:22
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Patrimonio</title>
    </head>
    <body>
        <h1>Novo Patrimonio</h1>
	<div>
	<label>Serie:</label>
	<input type="text" name="serie" value="${patrimonio.serie}" />
	</div><br>
	<div>
	<label>Local:</label>
	<input type="text" name="local" value="${patrimonio.local}" />
	</div><br>
	<div>
	<label>Descricao:</label>
	<input type="text" name="descricao" value="${patrimonio.descricao}" />
	</div>
	<div><br>
	<label>Estado:</label>
	<select name="estado" >
	    <option value="${patrimonio.estado}">Novo</option>
	    <option value="${patrimonio.estado}">Em uso</option>
	    <option value="${patrimonio.estado}">Danificado</option>
	    <option value="${patrimonio.estado}">Perdido</option>
	</select><br><br>
	<input type="submit" value="Enviar" name="" />
	</div>
    </body>
</html>
