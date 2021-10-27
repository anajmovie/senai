package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Entregador;

public class EntregadorDAO {
	// atributos principais
	private Connection con;
	private PreparedStatement ps;
	private Entregador entregador;
	private ArrayList<Entregador> entregadores;
	private ResultSet rs;
	
	// listando todos
	public ArrayList<Entregador> readAll() throws SQLException{
		entregadores = new ArrayList<>();
		String query = "select * from entregadores;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			entregador = new Entregador();
			entregador.setidEntregador(rs.getInt("id_entregador"));
			entregador.setnomeCompleto(rs.getString("nome_completo"));
			entregador.setVeiculo(rs.getString("veiculo"));
			entregadores.add(entregador);
		}
		con.close();
		return entregadores;
	}
	
	// criando um novo
	public int create(Entregador entregador) throws SQLException {
		String sql = "insert into entregadores (nome_completo, veiculo) values (?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, entregador.getnomeCompleto());
		ps.setString(2, entregador.getVeiculo());
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
	public boolean delete(String idEntregador) throws SQLException {
		String sql = "delete from entregadores where id_entregador = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(idEntregador));
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
	
	// editando pelo id
	public int update(Entregador entregador) throws SQLException {
		String sql = "update entregadores set nome_completo = ?, veiculo = ? where id_entregador = ?";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, entregador.getnomeCompleto());
		ps.setString(2, entregador.getVeiculo());
		ps.setInt(3, entregador.getidEntregador());
		return ps.executeUpdate();
	}
}