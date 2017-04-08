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
	<div><br>
	<label>Serie:</label>
	<input type="text" name="serie" value="" />
	</div><br>
	<div>
	<label>Local:</label>
	<input type="text" name="local" value="" />
	</div><br>
	<div>
	<label>Descricao:</label>
	<input type="text" name="descricao" value="" />
	</div><br>
	<div>
	<label>Estado:</label>
	<select name="estado">
	    <option value="0">Novo</option>
	    <option value="1">Em uso</option>
	    <option value="2">Danificado</option>
	    <option value="3">Perdido</option>
	</select><br><br>
	<input type="submit" value="Enviar" name="" />
	</div>
    </body>
</html>
