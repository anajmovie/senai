<%@page import="ctr.ClienteProcess"%>
<%@page import="vo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style/excluir.css">
<title>Exclusão de Cadastro</title>
</head>
<body>

	<h1>Exclusão do cadastro:</h1>
	<form method="GET">
		<b>ID do cliente:</b><input type="number" name="id" required><br><br>
		<input type="submit" value="Excluir">
	</form>
	
	<a href="receber.jsp">
		<button id="botao">Lista de Clientes</button>
	</a>

	<%
		Cliente cliente;
		String id = request.getParameter("id");
	
		if(id != null){
			cliente = new Cliente(Integer.parseInt(id));
			if(ClienteProcess.clientes.contains(cliente)){ //verifica se o cliente esta na lista
				int ind = ClienteProcess.clientes.indexOf(cliente); //obtem o indice
				cliente = ClienteProcess.clientes.get(ind); //pega todos os dados
				ClienteProcess.clientes.remove(ind);//remove o indice procurado
				out.print(ClienteProcess.salvar());
				response.sendRedirect("receber.jsp");
			}else{
				out.print("<p>Cliente não encontrado</p>");
			}			
		}else{
			out.print("<p>Não há nenhum dado para ser excluido</p>");	
		}
			
		
	%>



</body>
</html>