package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoProcess {

	public static ProdutoDAO pd;
	public static ArrayList<Produto> produtos;
	
	public static void carregarDados() throws SQLException {
		pd = new ProdutoDAO();
		produtos = pd.readAll();
	}
	
	public static int autoIncrementId() {
		if(produtos.size()<=0) {
			return 1;
		}else {
			return produtos.get(produtos.size()-1).getidProduto()+1;
		}
	}
}