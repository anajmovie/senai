package model;

import java.util.Objects;

public class Produto {
	// atributos
	private int id;;
	private String nome;
	private String descricao;
	private float valor;
	private int quantidade;
	
	// construtores
	public Produto() {
	}

	public Produto(int id) {
		this.id = id;
	}
	
	public Produto(int id, String nome, String descricao, float valor, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public Produto(String[] vetor) {
		this.id = Integer.valueOf(vetor[0]);
		this.nome = vetor[1];
		this.descricao = vetor[2];
		this.valor = Float.valueOf(vetor[3]);
		this.quantidade = Integer.valueOf(vetor[4]);
	}

	
	// getter e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// hashcode e equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	// metodo to string
	@Override
	public String toString() {
		return id + "\t" + nome + "\t" + descricao + "\t" + valor + "\t" + quantidade + "\t" + getSubtotal() + "\n";
	}
	
	public String toCSV() {
		return id + ";" + nome + ";" + descricao + ";" + valor + ";" + quantidade + ";" + getSubtotal() + "\n";
	}
	
	public String toHTML() {
		return "<tr><td>" + id + "</td><td>" + nome + "</td><td>" + descricao + "</td><td>" + valor + "</td><td>" + quantidade + "</td><td>" + getSubtotal() + "\n";
	}
	
	public double getSubtotal() {
		return valor * quantidade;
	}
}
