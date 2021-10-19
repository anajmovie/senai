package model;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Entregador {
	// atributos
	private int idEntregador;
	private String nome;
	private String veiculo;
	
	// contrutor vazio
	public Entregador() {
		
	}
	
	// construtor do id - string
	public Entregador(String idEntregador) {
		this.idEntregador = Integer.valueOf(idEntregador);
	}
	
	// contrutor cheio
	public Entregador(int idEntregador, String nome, String veiculo) {
		this.idEntregador = idEntregador;
		this.nome = nome;
		this.veiculo = veiculo;
	}
	
	// contrutor cheio - string
	public Entregador(String idEntregador, String nome, String veiculo) {
		this.idEntregador = Integer.valueOf(idEntregador);
		this.nome = nome;
		this.veiculo = veiculo;
	}

	// getter e setters
	public int getidEntregador() {
		return idEntregador;
	}

	public void setidEntregador(int idEntregador) {
		this.idEntregador = idEntregador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	// hash e equals
	@Override
	public int hashCode() {
		return Objects.hash(idEntregador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entregador other = (Entregador) obj;
		return idEntregador == other.idEntregador;
	}

	
	@Override
	public String toString() {
		return idEntregador + "\t" + nome + "\t" + veiculo + "\n";
	}
	
	public String toCSV() {
		return idEntregador + ";" + nome + ";" + veiculo + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("idEntregador", idEntregador);
			json.put("nome", nome);
			json.put("veiculo", veiculo);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}