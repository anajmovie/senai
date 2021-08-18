<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/cadastro.css">
<title>Cadastro de Clientes</title>
</head>
<body>

	<h1>Cadastre aqui um novo cliente:</h1>
	<form method="POST">
		<b>ID:</b><input type="number" name="id" required><br><br>
		<b>Nome:</b><input type="text" name="nome" required><br><br>
		<b>Objetivo:</b><input type="text" name="obj" required><br><br>
		<b>Plano:</b><input type="text" name="plano" required><br><br>
		<b>Valor:</b><input type="text" name="preco" required><br><br>
		<input type="submit" value="Cadastrar" id="botao">
	</form>

	<a href="receber.jsp">
		<button id="botao">Lista de Clientes</button>
	</a>

	<%
	Cliente cliente;
	String id = request.getParameter("id");
	String nome = request.getParameter("nome");
	String objetivo = request.getParameter("obj");
	String plano = request.getParameter("plano");
	String valor = request.getParameter("preco");
	
	if (id != null && nome != null && objetivo != null && plano != null && valor != null) {
		cliente = new Cliente(Integer.valueOf(id), nome, objetivo, plano, Double.valueOf(valor));
		ClienteProcess.clientes.add(cliente);
		out.print(ClienteProcess.salvar());
		response.sendRedirect("receber.jsp");
	} else {
	
	}
	%>

</body>
</html>