
<%@page import="control.ProdutoProcess"%>
<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/excluir.css">
<title>Excluir produto</title>
</head>
<body>

	<h1>Coloque o ID de um produto para exclui-lo</h1>
	
	<div class="bts">
		<a href="listar.jsp">
			<button>Lista de produtos</button>	
		</a>
		<a href="cadastro.jsp">
			<button>Cadastrar novo</button>	
		</a>
	</div>
	
	<form method="POST">
		<b>ID:</b><input type="number" name="id">
		<input type="submit" value="Excluir">
	</form>
	
	<%
		Produto produto;
		String id = request.getParameter("id");
		
		
		if(id != null){
			produto = new Produto(Integer.valueOf(id));
			if(ProdutoProcess.produtos.contains(produto)){ // se tiver o produto procurado na lista
				ProdutoProcess.produtos.remove(produto);
				ProdutoProcess.salvar();
				response.sendRedirect("listar.jsp");
			}
		}
	%>
</body>
</html>