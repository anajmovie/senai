package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.ItemDAO;
import model.ItemPedido;

public class ItemProcess {
	
	private static ItemDAO id;
	private static ArrayList<ItemPedido> itens;
	
	public static void carregarDados() throws SQLException {
		id = new ItemDAO();
		itens = id.readAll();
	}
}