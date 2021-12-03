package model;

public class Pescador {
	// atributos principais
	private int id;
	private String cidade;
	private int quantidade;
	
	// construtor vazio
	public Pescador() {
		
	}

	// construtor cheio
	public Pescador(int id, String cidade, int quantidade) {
		this.id = id;
		this.cidade = cidade;
		this.quantidade = quantidade;
	}

	// metodos acessores
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}