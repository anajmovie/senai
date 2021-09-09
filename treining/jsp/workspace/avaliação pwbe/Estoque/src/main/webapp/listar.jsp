
<%@page import="model.Produto"%>
<%@page import="control.ProdutoProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/listar.css">
<title>Lista de produtos</title>
</head>
<body>
	<h1>Lista de produtos já cadastrados</h1>
	
	<div class="btns">
		<a href="cadastro.jsp">
			<button>Cadastrar novo</button>
		</a>
		<a href="excluir.jsp">
			<button>Excluir produto</button>
		</a>
		<a href="buscar.jsp">
			<button>Buscar produto</button>
		</a>
	</div>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Quantidade</th>
			<th>Subtotal</th>
		</tr>
	
		<%
			ProdutoProcess.testes();
			out.print("<tbody>");
			for(Produto p: ProdutoProcess.produtos){
				out.print(p.toHTML());
			}
			out.print("</tbody>");
			ProdutoProcess.salvar();
		%>
	
	</table>
</body>
</html>