package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.PedidoDAO;
import model.Pedido;

public class PedidoProcess {

	public static PedidoDAO pd;
	public static ArrayList<Pedido> pedidos;
	
	public static int autoIncrementId() {
		if(pedidos.size()<=0) {
			return 1;
		}else {
			return pedidos.get(pedidos.size()-1).getidPedido()+1;
		}
	}
	
	// listando
	public static void carregarDados() throws SQLException {
		pd = new PedidoDAO();
		pedidos = pd.readAll();
	}
	

}