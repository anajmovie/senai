package vo;

public class Cliente {
	private int id;
	private String nome;
	private String objetivo;
	private String plano;
	private double valor;
	

	public Cliente(int id, String nome, String objetivo, String plano, double valor) {
		this.id = id;
		this.nome = nome;
		this.objetivo = objetivo;
		this.plano = plano;
		this.valor = valor;
	}

	public Cliente(String[] vetor) {
		this.id = Integer.valueOf(vetor[0]);
		this.nome = vetor[1];
		this.objetivo = vetor[2];
		this.plano = vetor[3];
		this.valor = Double.valueOf(vetor[4]);
	}
	
	public Cliente(int id) {
		this.id = id;	}

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

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
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
		if (id != other.id)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return id + "\t" + nome + "\t" + objetivo + "\t" + plano + "\t" + valor + "\n";
	}
	
	public String toCSV() {
		return id + ";" + nome + ";" + objetivo + ";" + plano + ";" + valor + "\n";
	}
	
	public String toHTML() {
		return "<tr><td>" + id + "</td><td>" + nome + "</td><td>" + objetivo + "</td><td>" + plano + "</td><td>" + valor + "</td></tr>";
	}
}
