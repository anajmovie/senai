package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteProcess {
	
	public static ClienteDAO cd;
	public static ArrayList<Cliente> clientes;
	private static JSONObject jo;
	public static Cliente cliente;
	
	public static int autoIncrementId() {
		if(clientes.size()<=0) {
			return 1;
		}else {
			return clientes.get(clientes.size()-1).getidCliente()+1;
		}
	}
	
	// listando
	public static void carregarDados() throws SQLException {
		cd = new ClienteDAO();
		clientes = cd.readAll();
	}
	
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
	// deletando
	public static boolean delete(String idCliente) throws SQLException {
		cd = new ClienteDAO();
		return cd.delete(idCliente);
	}
	
<<<<<<< Updated upstream
=======
>>>>>>> 1c5afc4e6cdaacd2b3e543738df9b3aed5458303
>>>>>>> Stashed changes
	// criando
	public static int create(String body) throws SQLException {
		cd = new ClienteDAO();
		try {
			jo = new JSONObject(body);
			cliente = new Cliente();
			cliente.setnomeCompleto(jo.getString("nome_completo"));
			cliente.setCpf(jo.getString("cpf"));
			cliente.setEmail(jo.getString("email"));
			cliente.setTelefone(jo.getString("telefone"));
			cliente.setSenha(jo.getString("senha"));
			cliente.setEndereco(jo.getString("endereco"));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return cd.create(cliente);
	}
<<<<<<< Updated upstream
}
=======
<<<<<<< HEAD
	
	// deletando
	public static boolean delete(String idCliente) throws SQLException {
		cd = new ClienteDAO();
		return cd.delete(idCliente);
	}
}
=======
}
>>>>>>> 1c5afc4e6cdaacd2b3e543738df9b3aed5458303
>>>>>>> Stashed changes
