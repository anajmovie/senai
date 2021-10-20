package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.PedidoDAO;
import model.Cliente;
import model.Entregador;
import model.Operador;
import model.Pedido;

public class PedidoProcess {

	public static PedidoDAO pd;
	public static ArrayList<Pedido> pedidos;
	
	public static void carregarDados() throws SQLException {
		pd = new PedidoDAO();
		pedidos = pd.readAll();
	}
	
<<<<<<< HEAD
	public static int autoIncrementId() {
		if(pedidos.size()<=0) {
			return 1;
		}else {
			return pedidos.get(pedidos.size()-1).getidPedido()+1;
		}
	}
	
=======
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
	public static void testes() {
		pedidos = new ArrayList<>();
		pedidos.add(new Pedido(1, 2, 2, 1));
		pedidos.add(new Pedido(2, 5, 2, 2));
		pedidos.add(new Pedido(3, 3, 3, 3));
		pedidos.add(new Pedido(4, 1, 3, 2));
	}
}