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
	private ResultSet rs;
	
	// listando todos
	public ArrayList<Cliente> readAll() throws SQLException{
		clientes = new ArrayList<>();
		String query = "select * from clientes;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			cliente = new Cliente();
			cliente.setidCliente(rs.getInt("id_cliente"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setnomeCompleto(rs.getString("nome_completo"));
			cliente.setEmail(rs.getString("email"));
			cliente.setSenha(rs.getString("senha"));
			cliente.setEndereco(rs.getString("endereco"));
			clientes.add(cliente);
		}
		con.close();
		return clientes;
	}
	
	// criando
	public int create(Cliente cliente) throws SQLException {
		String sql = "insert into clientes(nome_completo, cpf, email, telefone, senha, endereco) values (?, ?, ?, ?, ?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getnomeCompleto());
		ps.setString(2, cliente.getCpf());
		ps.setString(3, cliente.getEmail());
		ps.setString(4, cliente.getTelefone());
		ps.setString(5, cliente.getSenha());
		ps.setString(6, cliente.getEndereco());
		if(ps.executeUpdate() > 0) {
			rs = ps.getGeneratedKeys();
			rs.next();
			con.close();
			return rs.getInt(1);
		}else {
			return 0;
		}
	}
	
	// excluindo por id
	public boolean delete(String idCliente) throws SQLException {
		String sql = "delete from clientes where id_cliente = ?;";
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
	public int update(Cliente cliente) throws SQLException {
		String sql = "update clientes set nome_completo = ?, cpf = ?, email = ?, telefone = ?, senha = ?, endereco = ? where id_cliente = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getnomeCompleto());
		ps.setString(2, cliente.getCpf());
		ps.setString(3, cliente.getEmail());
		ps.setString(4, cliente.getTelefone());
		ps.setString(5, cliente.getSenha());
		ps.setString(6, cliente.getEndereco());
		ps.setInt(7, cliente.getidCliente());
		return ps.executeUpdate();
	}
}