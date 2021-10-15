<%@page import="java.util.ArrayList"%>
<%@page import="control.FuncionarioProcess"%>
<%@page import="model.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Funcionários</title>
</head>
<body>
	<form action="index.jsp" method="post">
		<input type="text" name="nome" id="nome"><br>
		<input type="text" name="doc" id="doc"><br>
		<input type="text" name="nasc" id="nasc"><br>
		<input type="text" name="registro" id="reg"><br>
		<input type="hidden" name="tipo" value="0" id="tipo">
		<input type="submit" value="Cadastrar">
	</form>
	<br>
	
	<%
		FuncionarioProcess fp = new FuncionarioProcess();

		String nome = request.getParameter("nome");
		String doc = request.getParameter("doc");
		String nasc = request.getParameter("nasc");
		String reg = request.getParameter("registro");
		String tipo = request.getParameter("tipo");
		
		System.out.println(nome);
		System.out.println(doc);
		System.out.println(nasc);
		System.out.println(reg);
		
		if(nome != null && doc != null && nasc != null && reg != null) {
			Funcionario f = new Funcionario();
			f.setNome(nome);
			f.setDoc(doc);
			f.setNascimento(Integer.parseInt(nasc));
			f.setRegistro(Integer.parseInt(reg));
			switch(tipo){
				case "0":
					fp.cadastrar(f);
					break;
				case "1":
					fp.editar(f);
					break;
				case "2":
					fp.excluir(f);
					break;
			}
		}
	%>
	
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Documento</th>
				<th>Nascimento</th>
				<th>Registro</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<String> data = fp.lista();
				for(String linha: data){
					String[] temp = linha.split(";");
					out.print("<tr>");
					out.print("<td>" + temp[0] + "</td>");
					out.print("<td>" + temp[1] + "</td>");
					out.print("<td>" + temp[2] + "</td>");
					out.print("<td>" + temp[3] + "</td>");
					out.print("<td><button onclick='edita(this)'>Editar</button></td>");
					out.print("<td><button onclick='exclui(this)'>Excluir</button></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
<script src="script.js"></script>
</html>