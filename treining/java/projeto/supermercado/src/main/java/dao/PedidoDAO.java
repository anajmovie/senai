package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
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
		String query = "select pedidos.*, operadores.id_funcionario from pedidos INNER JOIN operadores ON pedidos.id_caixa = operadores.id_caixa;"; // criando a query
		
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
			pedido.setCaixa(new Operador(rs.getString("id_caixa"), rs.getString("id_funcionario")));
			pedido.setData(rs.getDate("data"));
			pedido.setHoraPedido(rs.getTime("hora_pedido"));
			pedido.sethoraInicio(rs.getTime("hora_inicio"));
			pedido.sethoraFim(rs.getTime("hora_fim"));
			pedidos.add(pedido);
		}
		con.close(); // fecha a conexao com o banco
		return pedidos;
	}
	
	// criando
	public int create(Pedido pedido) throws SQLException {
		String sql = "insert into pedidos(id_cliente, id_entregador, id_caixa, data, hora_pedido, hora_inicio, hora_fim) values (?, ?, ?, ?, ?, ?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, pedido.getCliente().getidCliente());
		ps.setInt(2, pedido.getEntregador().getidEntregador());
		ps.setInt(3, pedido.getCaixa().getIdCaixa());
		ps.setDate(4, Date.valueOf(LocalDate.now())); // localDate representa uma data, o now() é a data de hoje
		ps.setTime(5, Time.valueOf(LocalTime.now())); // localTime representa um horário
		ps.setTime(6, (Time) pedido.gethoraInicio());
		ps.setTime(7, (Time) pedido.gethoraFim());
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
	
	// editando pelo id
	public int update(Pedido pedido) throws SQLException {
		String sql = "update pedidos set id_cliente = ?, id_entregador = ?, id_caixa = ?, data = ?, hora_pedido = ?, hora_inicio = ?, hora_fim = ? where id_pedido = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, pedido.getCliente().getidCliente());
		ps.setInt(2, pedido.getEntregador().getidEntregador());
		ps.setInt(3, pedido.getCaixa().getIdCaixa());
		ps.setString(4, pedido.getDataStr());
		ps.setString(5, pedido.getHoraPedidoStr());
		ps.setString(6, pedido.gethoraInicioStr());
		ps.setString(7, pedido.gethoraFimStr());
		ps.setInt(8, pedido.getidPedido());
		return ps.executeUpdate();
	}
}