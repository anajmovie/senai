package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.ItemDAO;
import model.ItemPedido;

public class ItemProcess {
	
	public static ItemDAO id;
	public static ArrayList<ItemPedido> itens;
	
	public static void carregarDados() throws SQLException {
		id = new ItemDAO();
		itens = id.readAll();
	}
	
	public static void testes() {
		itens = new ArrayList<>();
		itens.add(new ItemPedido(1, 3, 7, 92.75));
		itens.add(new ItemPedido(2, 5, 10, 43.0));
		itens.add(new ItemPedido(3, 7, 4, 22.0));
		itens.add(new ItemPedido(4, 10, 12, 50.0));
	}
}