package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.ItemDAO;
import model.ItemPedido;

public class ItemProcess {
	
	public static ItemDAO id;
	public static ArrayList<ItemPedido> itens;
	public ItemPedido item;
	
	// listando
	public static void carregarDados() throws SQLException {
		id = new ItemDAO();
		itens = id.readAll();
	}
	
	// deletando
	public static boolean delete(String idPedido) throws SQLException {
		id = new ItemDAO();
		return id.delete(idPedido);
	}
}