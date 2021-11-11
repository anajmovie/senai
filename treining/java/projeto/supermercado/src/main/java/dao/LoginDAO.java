package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Login;

public class LoginDAO {
	// atributos principais de conexão e envio
	private Connection con;
	private PreparedStatement ps;
	private Login login;
	private ArrayList<Login> logins;
	private ResultSet rs;
	
	// listando todos
	public ArrayList<Login> readAll() throws SQLException{
		logins = new ArrayList<>(); 				// inicia com a lista vazia
		String query = "select logins.id_cliente, clientes.email, clientes.senha from logins\r\n"
				+ "inner join clientes on logins.id_cliente = clientes.id_cliente;";		// criando a query
		con = ConnectionDB.getConnection();			// conecta, executa e retorna os dados
		ps = con.prepareStatement(query);			
		rs = ps.executeQuery(); 					// resultado executando comandos de select
		while(rs.next()) {							// percorre o resultado preenchendo a lista
			login = new Login();
			login.setCliente(new Cliente(rs.getString("id_cliente")));
			login.setConta(new Cliente(rs.getString("email"), rs.getString("senha")));;
			logins.add(login);
		}
		con.close(); 								// fecha a conexão com o banco
		return logins;
	}
}