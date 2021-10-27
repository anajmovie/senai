package model;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Operador {
	// atributos
	private int idCaixa;
	private int idFuncionario;
	private String nomeCompleto;
	private String cpf;
	
	// contrutor vazio
	public Operador() {
		
	}
	
	public Operador(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	
	// construtor do id - string
	public Operador(String idCaixa) {
		this.idCaixa = Integer.valueOf(idCaixa);
	}
	
	public Operador(int idCaixa, int idFuncionario) {
		this.idCaixa = idCaixa;
		this.idFuncionario = idFuncionario;
	}
	
	public Operador(String idCaixa, String idFuncionario) {
		this.idCaixa = Integer.valueOf(idCaixa);
		this.idFuncionario = Integer.valueOf(idFuncionario);
	}

	// contrutor cheio
	public Operador(int idCaixa, int idFuncionario, String nomeCompleto, String cpf) {
		this.idCaixa = idCaixa;
		this.idFuncionario = idFuncionario;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
	}
	
	// contrutor cheio - string
	public Operador(String idCaixa, String idFuncionario, String nomeCompleto, String cpf) {
		this.idCaixa = Integer.valueOf(idCaixa);
		this.idFuncionario = Integer.valueOf(idFuncionario);
		this.nomeCompleto = nomeCompleto;
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

	public String getnomeCompleto() {
		return nomeCompleto;
	}

	public void setnomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
		return idCaixa + "\t" + idFuncionario + "\t" + nomeCompleto + "\t" + cpf + "\n";
	}

	public String toCSV() {
		return idCaixa + ";" + idFuncionario + ";" + nomeCompleto + ";" + cpf + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id_caixa", idCaixa);
			json.put("id_funcionario", idFuncionario);
			json.put("nome_completo", nomeCompleto);
			json.put("cpf", cpf);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}