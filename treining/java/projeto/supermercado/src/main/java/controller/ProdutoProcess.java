package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoProcess {

	public static ProdutoDAO pd;
	public static ArrayList<Produto> produtos;
	private static JSONObject jo;
	public static Produto produto;
	
	public static int autoIncrementId() {
		if(produtos.size()<=0) {
			return 1;
		}else {
			return produtos.get(produtos.size()-1).getidProduto()+1;
		}
	}
	
	// listando
	public static void carregarDados() throws SQLException {
		pd = new ProdutoDAO();
		produtos = pd.readAll();
	}
	
	// criando
	public static int create(String body) throws SQLException {
		pd = new ProdutoDAO();
		try {
			jo = new JSONObject(body);
			produto = new Produto();
			produto.setNome(jo.getString("nome"));
			produto.setDescricao(jo.getString("descricao"));
			produto.setPreco(jo.getDouble("preco"));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return pd.create(produto);
	}
	
	// deletando
	public static boolean delete(String idProduto) throws SQLException {
		pd = new ProdutoDAO();
		return pd.delete(idProduto);
	}
}