<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/lista.css">
<title>Lista de Clientes (READ)</title>
</head>
<body>
	<h1>Lista de clientes cadastrados:</h1>
	<div class="btns">
		<a href="cadastro.jsp">
			<button id="botao">Cadastrar Novo</button>
		</a>
		<a href="excluir.jsp">
			<button id="excluir">Excluir Cadastro</button>
		</a>
		<a href="buscar.jsp">
			<button id="buscar">Buscar Cliente</button>
		</a>
	</div>

	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Objetivo</th>
			<th>Plano</th>
			<th>Preço</th>
		</tr>
		
		<%
		ClienteProcess.abrir();
		out.print("<tbody>" );
		for (Cliente c : ClienteProcess.clientes) {
			out.print(c.toHTML());
		}
		out.print("</tbody>");
		out.print(ClienteProcess.salvar());
		%>
	
	</table>
</body>
</html>