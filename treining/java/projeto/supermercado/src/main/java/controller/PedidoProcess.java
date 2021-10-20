package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.PedidoDAO;
import model.Pedido;

public class PedidoProcess {

	public static PedidoDAO pd;
	public static ArrayList<Pedido> pedidos;
	
	public static void carregarDados() throws SQLException {
		pd = new PedidoDAO();
		pedidos = pd.readAll();
	}
	
	public static int autoIncrementId() {
		if(pedidos.size()<=0) {
			return 1;
		}else {
			return pedidos.get(pedidos.size()-1).getidPedido()+1;
		}
	}
	
	public static void testes() {
		pedidos = new ArrayList<>();
		pedidos.add(new Pedido(1, 2, 2, 1));
		pedidos.add(new Pedido(2, 5, 2, 2));
		pedidos.add(new Pedido(3, 3, 3, 3));
		pedidos.add(new Pedido(4, 1, 3, 2));
	}
}