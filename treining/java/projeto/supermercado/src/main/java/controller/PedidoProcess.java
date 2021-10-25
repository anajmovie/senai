package controller;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import dao.PedidoDAO;
import model.Cliente;
import model.Entregador;
import model.Operador;
import model.Pedido;

public class PedidoProcess {

	public static PedidoDAO pd;
	public static ArrayList<Pedido> pedidos;
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	private static JSONObject jo;
	public static Pedido pedido;
=======
>>>>>>> 1c5afc4e6cdaacd2b3e543738df9b3aed5458303
>>>>>>> Stashed changes
	
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
	
<<<<<<< Updated upstream

=======
<<<<<<< HEAD
	// criando
	/*public static int create(String body) throws SQLException {
		pd = new PedidoDAO();
		try {
			jo = new JSONObject(body);
			pedido = new Pedido();
			pedido.setCliente(new Cliente(jo.getInt("id_cliente")));
			pedido.setEntregador(new Entregador(jo.getInt("id_entregador")));
			pedido.setCaixa(new Operador(jo.getInt("id_caixa")));
			pedido.setData(new Date(jo.getInt("data")));
			pedido.setHora_pedidPedidoo(new Time(jo.getInt("hora_pedido")));
			pedido.sethoraInicio(new Time(jo.getInt("hora_inicio")));
			pedido.sethoraFim(new Time(jo.getInt("hora_fim")));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return pd.create(pedido);
	}*/
	
	// deletando
	public static boolean delete(String idPedido) throws SQLException {
		pd = new PedidoDAO();
		return pd.delete(idPedido);
	}
=======

>>>>>>> 1c5afc4e6cdaacd2b3e543738df9b3aed5458303
>>>>>>> Stashed changes
}