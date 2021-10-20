package model;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Operador {
	// atributos
	private int idCaixa;
	private int idFuncionario;
	private String nome;
	private String cpf;
	
	// contrutor vazio
	public Operador() {
		
	}
	
	// construtor do id - string
	public Operador(String idCaixa) {
		this.idCaixa = Integer.valueOf(idCaixa);
	}

	// contrutor cheio
	public Operador(int idCaixa, int idFuncionario, String nome, String cpf) {
		this.idCaixa = idCaixa;
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	// contrutor cheio - string
	public Operador(String idCaixa, String idFuncionario, String nome, String cpf) {
		this.idCaixa = Integer.valueOf(idCaixa);
		this.idFuncionario = Integer.valueOf(idFuncionario);
		this.nome = nome;
		this.cpf = cpf;
	}

	// getter e setters
	public int getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// hash e equals
	@Override
	public int hashCode() {
		return Objects.hash(idCaixa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operador other = (Operador) obj;
		return idCaixa == other.idCaixa;
	}

	@Override
	public String toString() {
		return idCaixa + "\t" + idFuncionario + "\t" + nome + "\t" + cpf + "\n";
	}

	public String toCSV() {
		return idCaixa + ";" + idFuncionario + ";" + nome + ";" + cpf + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("idCaixa", idCaixa);
			json.put("idFuncionario", idFuncionario);
			json.put("nome", nome);
			json.put("cpf", cpf);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}