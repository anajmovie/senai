package model;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import controller.ClienteProcess;

public class Cliente {
	// atributos
	private int idCliente;
	private String cpf;
	private String nomeCompleto;
	private String email;
	private String senha;
	private String endereco;
	private String telefone;
	
	// construtor vazio
	public Cliente() {
		
	}
	
	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	// construtor do id - string
	public Cliente(String idCliente) {
		this.idCliente = Integer.valueOf(idCliente);
	}
	
	public Cliente(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente(String idCliente, String email, String senha) {
		this.idCliente = Integer.valueOf(idCliente);
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente(int idCliente, String email, String senha) {
		this.idCliente = idCliente;
		this.email = email;
		this.senha = senha;
	}

	// contrutor cheio
	public Cliente(int idCliente, String cpf, String nomeCompleto, String email, String senha, String endereco, String telefone) {
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	// contrutor cheio - string
	public Cliente(String idCliente, String cpf, String nomeCompleto, String email, String senha, String endereco, String telefone) {
		this.idCliente = Integer.valueOf(idCliente);
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Cliente(String cpf, String nomeCompleto, String email, String senha, String endereco, String telefone) {
		this.idCliente = ClienteProcess.autoIncrementId();
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	// getters e setters
	public int getidCliente() {
		return idCliente;
	}

	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getnomeCompleto() {
		return nomeCompleto;
	}

	public void setnomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	// hashcode e equals
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	// metodo toString
	@Override
	public String toString() {
		return idCliente + "\t" + cpf + "\t" + nomeCompleto + "\t" + email + "\t" + senha + "\t" + endereco + "\t" + telefone + "\n";
	}
	
	// metodo toCSV
	public String toCSV() {
		return idCliente + ";" + cpf + ";" + nomeCompleto + ";" + email + ";" + senha + ";" + endereco + ";" + telefone + "\r\n";
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id_cliente", idCliente);
			json.put("cpf", cpf);
			json.put("nome_completo", nomeCompleto);
			json.put("email", email);
			json.put("senha", senha);
			json.put("endereco", endereco);
			json.put("telefone", telefone);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}