package model;

public class Funcionario {
	// atributos
	private String nome;
	private String doc;
	private int nascimento;
	private int registro;

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNascimento() {
		return nascimento;
	}

	public void setNascimento(int nascimento) {
		this.nascimento = nascimento;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}


	// metodo
	public void trabalhando() {
		System.out.println("Estou trabalhando, não estorva");
	}
}
