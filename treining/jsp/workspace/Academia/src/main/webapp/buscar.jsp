<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/busca.css">
<title>Buscar Cadastro</title>
</head>
<body>
	
	<h1>Busca de cadastro de clientes:</h1>
	<form method="GET">
		<b>ID do cliente:</b><input type="text" name="buscar" required>
		<input type="submit" value="Buscar Cliente">
	</form>
	
	<%
		String id = request.getParameter("buscar");
		Cliente cliente;
		
		if(id != null){
			cliente = new Cliente(Integer.parseInt(id));
			if(ClienteProcess.clientes.contains(cliente)){
				int ind = ClienteProcess.clientes.indexOf(cliente);
				cliente = ClienteProcess.clientes.get(ind);
				out.print(cliente.toString());
			}else{
				out.print("<p>Cliente não encontrado</p>");
			}
		}else{
			out.print("<p>Digite um ID para buscar</p>");
		}
	%>
	
	<a href="receber.jsp">
		<button id="botao">Lista de Clientes</button>
	</a>
</body>
</html>