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
	
<<<<<<< HEAD
	public static int autoIncrementId() {
		if(produtos.size()<=0) {
			return 1;
		}else {
			return produtos.get(produtos.size()-1).getidProduto()+1;
		}
	}
	
=======
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
	public static void testes() {
		produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Sabonete", "Palmolive Tamanho Família 150g", 2.89));
		produtos.add(new Produto(2, "Creme Dental", "Colgate Sorriso Mais Branco", 4.97));
		produtos.add(new Produto(3, "Enxaguante Bucal", "Listerine Menta", 13.25));
		produtos.add(new Produto(4, "Fio Dental", "Frescor Mais Fino", 2.36));
<<<<<<< HEAD
=======
		
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
	}
}