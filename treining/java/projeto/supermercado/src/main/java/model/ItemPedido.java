package model;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemPedido {
	// atributos
	private Pedido pedido;
	private Produto produto;
	private int quantidade;
	private double subtotal;
	
	// construtor vazio
	public ItemPedido() {
		
	}
	
	public ItemPedido(String idPedido) {
		this.pedido = new Pedido(idPedido);
	}
	
	public ItemPedido(int idPedido, int idProduto, int quantidade, double subtotal) {
		this.pedido = new Pedido(idPedido); 
		this.produto = new Produto(idProduto);
		this.quantidade = quantidade;
		this.subtotal = subtotal;
	}

	// construtor cheio
	public ItemPedido(Pedido pedido, Produto produto, int quantidade, double subtotal) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
	}
	
	// construtor cheio - string
	public ItemPedido(String idPedido, String idProduto, String quantidade, String subtotal) {
		this.pedido = new Pedido(idPedido);
		this.produto = new Produto(idProduto);
		this.quantidade = Integer.valueOf(quantidade);
		this.subtotal = Double.valueOf(subtotal);
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

	public double getsubtotal() {
		return subtotal;
	}

	public void setsubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	
	@Override
	public String toString() {
		return pedido.getidPedido() + "\t" + produto.getidProduto() + "\t" + quantidade + "\t" + subtotal + "\n";
	}
	
	public String toCSV() {
		return pedido.getidPedido() + ";" + produto.getidProduto() + ";" + quantidade + ";" + subtotal + "\r\n";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("pedido", pedido.toJSON());
			json.put("produto", produto.toJSON());
			json.put("quantidade", quantidade);
			json.put("subtotal", subtotal);
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}