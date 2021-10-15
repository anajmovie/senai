
<%@page import="control.ProdutoProcess"%>
<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/cadastro.css">
<title>Cadastro de produtos</title>
</head>
<body>
	
	<h1>Cadastre um novo produto aqui</h1>
	<form method="POST">
		<b>ID:</b><input type="number" name="id"><br><br>
		<b>Nome:</b><input type="text" name="nome"><br><br>
		<b>Descrição:</b><input type="text" name="desc"><br><br>
		<b>Valor:</b><input type="text" name="valor"><br><br>
		<b>Quantidade:</b><input type="number" name="quant"><br><br>
		<b></b><input type="submit" value="Cadastrar"><br><br>
	</form>
	
	<%
		Produto produto;
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		String valor = request.getParameter("valor");
		String quant = request.getParameter("quant");
		
		if(id != null && nome != null && desc != null && valor != null && quant != null){
			produto = new Produto(Integer.valueOf(id), nome, desc, Float.valueOf(valor), Integer.valueOf(quant));
			ProdutoProcess.produtos.add(produto);
			ProdutoProcess.salvar();
			response.sendRedirect("listar.jsp");
		}else{
			
		}
	%>
	
	<a href="listar.jsp">
		<button>Lista de Produtos</button>
	</a>
	
</body>
</html>