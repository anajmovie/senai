package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Login {
	// atributos
	private Cliente cliente;
	private Cliente conta;

	// construtor vazio
	public Login() {

	}
	
	public Login(String idCliente) {
		this.cliente = new Cliente(idCliente);
	}

	// construtor cheio
	public Login(Cliente cliente, Cliente conta, Cliente contaSenha) {
		this.cliente = cliente;
		this.conta = conta;
		this.conta = contaSenha;
	}
	
	// construtor cheio - string
	public Login(String idCliente, String email, String senha) {
		this.cliente = new Cliente(idCliente);
		this.conta = new Cliente(email);
		this.conta = new Cliente(senha);
	}
	
	public Login(String email, String senha) {
		this.conta = new Cliente(email);
		this.conta = new Cliente(senha);
	}

	// getter e setter
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getConta() {
		return conta;
	}

	public void setConta(Cliente conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return cliente.getidCliente() + "\t" + conta.getEmail() + "\t" + conta.getSenha() + "\n";
	}
	
	public String toCSV() {
		return cliente.getidCliente() + ";" + conta.getEmail() + ";" + conta.getSenha() + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("cliente", cliente.toJSON());
			json.put("conta", conta.toJSON());
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: "+e);
		}
		return json;
	}	
}