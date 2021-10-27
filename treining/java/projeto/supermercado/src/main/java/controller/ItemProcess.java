package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import dao.ItemDAO;
import model.ItemPedido;
import model.Produto;

public class ItemProcess {
	
	public static ItemDAO id;
	public static ArrayList<ItemPedido> itens;
	public static ItemPedido item;
	private static JSONObject jo;
	
	// listando
	public static void carregarDados() throws SQLException {
		id = new ItemDAO();
		itens = id.readAll();
	}
	
	// criando
	public static int create(String body) throws SQLException {
		id = new ItemDAO();
		try {
			jo = new JSONObject(body);
			item = new ItemPedido();
			item.setProduto(new Produto(jo.getInt("id_produto")));
			item.setQuantidade(jo.getInt("quantidade"));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return id.create(item);
	}
	
	// deletando
	public static boolean delete(String idPedido) throws SQLException {
		id = new ItemDAO();
		return id.delete(idPedido);
	}
}