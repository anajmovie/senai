package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteProcess {
	
	public static ClienteDAO cd;
	public static ArrayList<Cliente> clientes;
	
	public static void carregarDados() throws SQLException {
		cd = new ClienteDAO();
		clientes = cd.readAll();
	}
	
	public static int autoIncrementId() {
		if(clientes.size()<=0) {
			return 1;
		}else {
			return clientes.get(clientes.size()-1).getidCliente()+1;
		}
	}
	
	public static void testes() {
		clientes = new ArrayList<>();
		clientes.add(new Cliente(1, "11111111111", "Akeme Dias", "akeme1@gmail.com", "akeme123", "Rua Pedro Lana, 333", "11111111111"));
		clientes.add(new Cliente(2, "11111111111", "Alana Dias", "alana1@gmail.com", "alana123", "Rua Pedro Lana, 300", "11111111111"));
		clientes.add(new Cliente(3, "11111111111", "Abna Dias", "aabna1@gmail.com", "abna123", "Rua Pedro Lana, 303", "11111111111"));
		clientes.add(new Cliente(4, "11111111111", "Augusto Dias", "augusto1@gmail.com", "augusto123", "Rua Pedro Lana, 33", "11111111111"));
	}
}
