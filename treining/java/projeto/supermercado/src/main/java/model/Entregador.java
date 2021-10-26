package model;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Entregador {
	// atributos
	private int idEntregador;
	private String nomeCompleto;
	private String veiculo;
	
	// contrutor vazio
	public Entregador() {
		
	}
	
	public Entregador(int idEntregador) {
		this.idEntregador = idEntregador;
	}
	
	// construtor do id - string
	public Entregador(String idEntregador) {
		this.idEntregador = Integer.valueOf(idEntregador);
	}
	
	// contrutor cheio
	public Entregador(int idEntregador, String nomeCompleto, String veiculo) {
		this.idEntregador = idEntregador;
		this.nomeCompleto = nomeCompleto;
		this.veiculo = veiculo;
	}
	
	// contrutor cheio - string
	public Entregador(String idEntregador, String nomeCompleto, String veiculo) {
		this.idEntregador = Integer.valueOf(idEntregador);
		this.nomeCompleto = nomeCompleto;
		this.veiculo = veiculo;
	}

	// getter e setters
	public int getidEntregador() {
		return idEntregador;
	}

	public void setidEntregador(int idEntregador) {
		this.idEntregador = idEntregador;
	}

	public String getnomeCompleto() {
		return nomeCompleto;
	}

	public void setnomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
		return idEntregador + "\t" + nomeCompleto + "\t" + veiculo + "\n";
	}
	
	public String toCSV() {
		return idEntregador + ";" + nomeCompleto + ";" + veiculo + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id_entregador", idEntregador);
			json.put("nome_completo", nomeCompleto);
			json.put("veiculo", veiculo);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}