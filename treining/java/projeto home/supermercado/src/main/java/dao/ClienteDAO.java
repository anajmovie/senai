package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

public class ClienteDAO {
	// atributos principais
	private Connection con;
	private PreparedStatement ps;
	private Cliente cliente;
	private ArrayList<Cliente> clientes;
	
	// listando todos
	public ArrayList<Cliente> readAll() throws SQLException{
		clientes = new ArrayList<>();
		String query = "select * from clientes;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			cliente = new Cliente();
			cliente.setidCliente(rs.getInt("id_cliente"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setNome(rs.getString("nome_completo"));
			cliente.setEmail(rs.getString("email"));
			cliente.setSenha(rs.getString("senha"));
			cliente.setEndereco(rs.getString("endereco"));
			clientes.add(cliente);
		}
		con.close();
		return clientes;
	}
}