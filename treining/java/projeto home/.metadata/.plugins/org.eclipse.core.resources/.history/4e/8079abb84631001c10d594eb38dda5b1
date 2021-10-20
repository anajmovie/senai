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
}