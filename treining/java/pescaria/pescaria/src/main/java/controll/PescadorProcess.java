package controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Pescador;

public class PescadorProcess {
	
	// atributos principais
	public static PreparedStatement ps;
	public static Connection con;
	public static ResultSet rs;
	private JSONObject json;
	
	// read
	public JSONArray readAll() throws SQLException, JSONException {
		JSONArray ja = new JSONArray();
		
		String sql = "select * from pescador";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			json = new JSONObject();
			json.put("id", rs.getInt("id"));
			json.put("cidade", rs.getString("cidade"));
			json.put("quantidade", rs.getInt("quantidade"));
			ja.put(json);
		}
		con.close();
		return ja;
	}
	
	
	// create
	public int create(Pescador pesc) throws SQLException {
		String sql = "insert into pescador(cidade, quantidade) values (?, ?)";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, pesc.getCidade());
		ps.setInt(2, pesc.getQuantidade());
		if(ps.executeUpdate() > 0) {
			rs = ps.getGeneratedKeys();
			rs.next();
			con.close();
			return rs.getInt(1);
		}
		return 0;
	}
	
	// delete
	public boolean delete(int id) throws SQLException {
		String sql = "delete from pescador where id = ?";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
	
	// update
	public int update(Pescador pesc) throws SQLException {
		String sql = "update pescador set cidade = ?, quantidade = ? where id = ?";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, pesc.getCidade());
		ps.setInt(2, pesc.getQuantidade());
		ps.setInt(3, pesc.getId());
		return ps.executeUpdate();
	}
}