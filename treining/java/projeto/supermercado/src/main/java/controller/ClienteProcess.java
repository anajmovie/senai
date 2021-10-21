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
}
