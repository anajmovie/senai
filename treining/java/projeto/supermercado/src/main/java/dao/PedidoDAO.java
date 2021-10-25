package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Entregador;
import model.Operador;
import model.Pedido;

public class PedidoDAO {
	// atributos principais de conexao e envio
	private Connection con; // conexao
	private PreparedStatement ps; // envio
	private Pedido pedido;
	private ArrayList<Pedido> pedidos;
	private ResultSet rs;
	
	// listando todos
	public ArrayList<Pedido> readAll() throws SQLException{
		pedidos = new ArrayList<>(); // inicia com a lista vazia
		String query = "select * from pedidos;"; // criando a query
		
		// conecta, executa e retorna os dados
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery(); // resultado
		
		// percorre o resultado preenchendo a lista
		while(rs.next()) {
			pedido = new Pedido();
			pedido.setidPedido(rs.getInt("id_pedido"));
			pedido.setCliente(new Cliente(rs.getString("id_cliente")));
			pedido.setEntregador(new Entregador(rs.getString("id_entregador")));
			pedido.setCaixa(new Operador(rs.getString("id_caixa")));
			pedido.setData(rs.getDate("data"));
			pedido.setHora_pedidPedidoo(rs.getTime("hora_pedido"));
			pedido.sethoraInicio(rs.getTime("hora_inicio"));
			pedido.sethoraFim(rs.getTime("hora_fim"));
			pedidos.add(pedido);
		}
		con.close(); // fecha a conexao com o banco
		return pedidos;
	}
	
	// criando
	/*public int create(Pedido pedido) throws SQLException {
		String sql = "insert into pedidos(id_cliente, id_entregador, id_caixa, data, hora_pedido, hora_inicio, hora_fim) values (?, ?, ?, ?, ?, ?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, pedido.getCliente());
		ps.setInt(2, pedido.getEntregador());
		ps.setInt(3, pedido.getCaixa());
		ps.setDate(4, pedido.getData());
		ps.setTime(5, pedido.getHora_pedidPedidoo());
		ps.setTime(6, pedido.gethoraInicio());
		ps.setTime(7, pedido.gethoraFim());
		if(ps.executeUpdate() > 0) {
			rs = ps.getGeneratedKeys();
			rs.next();
			con.close();
			return rs.getInt(1);
		}else {
			return 0;
		}
	}*/
	
	// excluindo por id
	public boolean delete(String idPedido) throws SQLException {
		String sql = "delete from pedidos where id_pedido = ?;";
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