package model;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Produto {
	// atributos
	private int idProduto;
	private String nome;
	private String descricao;
	private double preco;
	
	// contrutor vazio
	public Produto() {
		
	}
	
	// construtor do id - string
	public Produto(String idProduto) {
		this.idProduto = Integer.valueOf(idProduto);
	}
	
	// contrutor cheio
	public Produto(int idProduto, String nome, String descricao, double preco) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	// contrutor cheio - string
	public Produto(String idProduto, String nome, String descricao, String preco) {
		this.idProduto = Integer.valueOf(idProduto);
		this.nome = nome;
		this.descricao = descricao;
		this.preco = Double.valueOf(preco);
	}

	// getter e setters
	public int getidProduto() {
		return idProduto;
	}

	public void setidProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	// hashcode e equals
	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return idProduto == other.idProduto;
	}

	// metodo toString
	@Override
	public String toString() {
		return idProduto + "\t" + nome + "\t" + descricao + "\t" + preco + "\n";
	}
	
	// metodo toCSV
	public String toCSV() {
		return idProduto + ";" + nome + ";" + descricao + ";" + preco + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("idProduto", idProduto);
			json.put("nome", nome);
			json.put("descricao", descricao);
			json.put("preco", preco);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}