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
		String query = "select logins.*, clientes.email, clientes.senha from logins\r\n"
				+ "inner join clientes on logins.id_cliente = clientes.id_cliente;";		// criando a query
		con = ConnectionDB.getConnection();			// conecta, executa e retorna os dados
		ps = con.prepareStatement(query);			
		rs = ps.executeQuery(); 					// resultado executando comandos de select
		while(rs.next()) {							// percorre o resultado preenchendo a lista
			login = new Login();
			login.setCliente(new Cliente(rs.getString("id_cliente"), rs.getString("email"), rs.getString("senha")));
			//login.setConta(new Cliente(rs.getString("email"), rs.getString("senha")));;
			logins.add(login);
		}
		con.close(); 								// fecha a conexão com o banco
		return logins;
	}
	
	//criando
	public int create(Login login) throws SQLException {
		String sql = "insert into logins(email, senha) values (?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, login.getCliente().getEmail());
		ps.setString(2, login.getCliente().getSenha());
		if(ps.executeUpdate() > 0) {
			rs = ps.getGeneratedKeys();
			rs.next();
			con.close();
			return rs.getInt(1);
		}else {
			return 0;
		}
	}
	
	// deletando pelo id
	public boolean delete(String idCliente) throws SQLException {
		String sql = "delete from logins where id_cliente = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(idCliente));
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
	
	// editando pelo id
	public int update(Login login) throws SQLException {
		String sql = "update logins set email = ?, senha = ? where id_cliente = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, login.getCliente().getEmail());
		ps.setString(2, login.getCliente().getSenha());
		ps.setInt(3, login.getCliente().getidCliente());
		return ps.executeUpdate();
	}	
}