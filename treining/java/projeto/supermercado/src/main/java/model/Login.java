package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Login {
	// atributos
	private Cliente cliente;
	//private Cliente conta;

	// construtor vazio
	public Login() {

	}
	
	public Login(int idCliente) {
		this.cliente = new Cliente(idCliente);
	}
	
	public Login(String idCliente) {
		this.cliente = new Cliente(idCliente);
	}

	// construtor cheio
	public Login(Cliente cliente, Cliente cliemail, Cliente clisenha) {
		this.cliente = cliente;
		this.cliente = cliemail;
		this.cliente = clisenha;
	}
	
	// construtor cheio - string
	public Login(String idCliente, String email, String senha) {
		this.cliente = new Cliente(idCliente);
		this.cliente = new Cliente(email);
		this.cliente = new Cliente(senha);
	}

	// getter e setter
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return cliente.getidCliente() + "\t" + cliente.getEmail() + "\t" + cliente.getSenha() + "\n";
	}
	
	public String toCSV() {
		return cliente.getidCliente() + ";" + cliente.getEmail() + ";" + cliente.getSenha() + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("cliente", cliente.toJSON());
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: "+e);
		}
		return json;
	}	
}