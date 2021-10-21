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
	
	// listando todos
	public ArrayList<Entregador> readAll() throws SQLException{
		entregadores = new ArrayList<>();
		String query = "select * from entregadores;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			entregador = new Entregador();
			entregador.setidEntregador(rs.getInt("id_entregador"));
			entregador.setNome(rs.getString("nome_completo"));
			entregador.setVeiculo(rs.getString("veiculo"));
			entregadores.add(entregador);
		}
		con.close();
		return entregadores;
	}
}