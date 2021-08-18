package ctr;


import java.util.ArrayList;
import dao.ClienteDAO;
import vo.Cliente;

public class ClienteProcess {
	
	public static ArrayList<Cliente> clientes;
	public static ClienteDAO cd = new ClienteDAO();
	
	public static void testes() {
		clientes = new ArrayList<>();
		clientes.add(new Cliente(1, "Akeme Dias", "Definir", "Calistenia", 90.0));
		clientes.add(new Cliente(2, "Ana Beatriz Gomes", "Emagrecer", "Zumba", 60.0));
		clientes.add(new Cliente(3, "Carina Bernardes", "Fortalecer", "Pilates", 85.0));
		clientes.add(new Cliente(4, "Marcos Ribeiro", "Crescer", "Musculaçao", 90.0));
	}
	
	public static void abrir() {
		clientes = cd.abrir();
	}
	
	
	public static String salvar() {
		if(cd.salvar(clientes)) {
			return "<p>Dados registrados</p>";
		}
		return "<p>Erro ao registar dados</p>";
	}
}


