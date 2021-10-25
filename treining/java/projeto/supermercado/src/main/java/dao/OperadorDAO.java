package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Operador;

public class OperadorDAO {
	// atributos principais
	private Connection con;
	private PreparedStatement ps;
	private Operador operador;
	private ArrayList<Operador> operadores;
	private ResultSet rs;
	
	// listando todos
	public ArrayList<Operador> readAll() throws SQLException{
		operadores = new ArrayList<>();
		String query = "select * from operadores;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			operador = new Operador();
			operador.setIdCaixa(rs.getInt("id_caixa"));
			operador.setIdFuncionario(rs.getInt("id_funcionario"));
			operador.setnomeCompleto(rs.getString("nome_completo"));
			operador.setCpf(rs.getString("cpf"));
			operadores.add(operador);
		}
		con.close();
		return operadores;
	}
	
	// criando um novo
	public int create(Operador operador) throws SQLException {
		String sql = "insert into operadores (id_funcionario, nome_completo, cpf) values (?, ?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, operador.getIdFuncionario());
		ps.setString(2, operador.getnomeCompleto());
		ps.setString(3, operador.getCpf());
		if(ps.executeUpdate() > 0) {
			rs = ps.getGeneratedKeys();
			rs.next();
			con.close();
			return rs.getInt(1);
		}else {
			return 0;
		}
	}
	
	// excluindo pelo id
	public boolean delete(String idCaixa) throws SQLException {
		String sql = "delete from operadores where id_caixa = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(idCaixa));
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
}