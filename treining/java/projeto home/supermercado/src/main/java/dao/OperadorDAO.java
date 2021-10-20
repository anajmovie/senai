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
	
	// listando todos
	public ArrayList<Operador> readAll() throws SQLException{
		operadores = new ArrayList<>();
		String query = "select * from operadores;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			operador = new Operador();
			operador.setIdCaixa(rs.getInt("id_caixa"));
			operador.setIdFuncionario(rs.getInt("id_funcionario"));
			operador.setNome(rs.getString("nome_completo"));
			operador.setCpf(rs.getString("cpf"));
			operadores.add(operador);
		}
		con.close();
		return operadores;
	}
}