package model;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemPedido {
	// atributos
	private Pedido pedido;
	private Produto produto;
	private int quantidade;
	
	// construtor vazio
	public ItemPedido() {
		
	}
	
	public ItemPedido(String idPedido) {
		this.pedido = new Pedido(idPedido);
	}
	
	public ItemPedido(int idPedido, int idProduto, int quantidade) {
		this.pedido = new Pedido(idPedido); 
		this.produto = new Produto(idProduto);
		this.quantidade = quantidade;
	}

	// construtor cheio
	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	// construtor cheio - string
	public ItemPedido(String idPedido, String idProduto, String quantidade) {
		this.pedido = new Pedido(idPedido);
		this.produto = new Produto(idProduto);
		this.quantidade = Integer.valueOf(quantidade);
	}

	
	// getters e setters
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	@Override
	public String toString() {
		return pedido.getidPedido() + "\t" + produto.getidProduto() + "\t" + quantidade + "\n";
	}
	
	public String toCSV() {
		return pedido.getidPedido() + ";" + produto.getidProduto() + ";" + quantidade + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("pedido", pedido.toJSON());
			json.put("produto", produto.toJSON());
			json.put("quantidade", quantidade);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}