package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

public class ItemDAO {
	// atributos principais
	private Connection con;
	private PreparedStatement ps;
	private ItemPedido item;
	private ArrayList<ItemPedido> itens;
	private ResultSet rs;
	
	// listando todos
	public ArrayList<ItemPedido> readAll() throws SQLException{
		itens = new ArrayList<>();
		String query = "select * from itens;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			item = new ItemPedido();
			item.setPedido(new Pedido(rs.getString("id_pedido")));
			item.setProduto(new Produto(rs.getString("id_produto")));
			item.setQuantidade(rs.getInt("quantidade"));
			item.setsubtotal(rs.getDouble("subtotal"));
			itens.add(item);
		}
		con.close();
		return itens;
	}
	
	// criando
		public int create(ItemPedido item) throws SQLException {
			String sql = "insert into itens(id_produto, quantidade, subtotal) values (?, ?, ?);";
			con = ConnectionDB.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, item.getProduto().getidProduto());
			ps.setInt(2, item.getQuantidade());
			ps.setDouble(3, item.getsubtotal());
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
	public boolean delete(String idPedido) throws SQLException {
		String sql = "delete from itens where id_pedido = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(idPedido));
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
}
