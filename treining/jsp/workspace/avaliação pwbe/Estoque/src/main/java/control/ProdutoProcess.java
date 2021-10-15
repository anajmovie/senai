package control;

import java.util.ArrayList;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoProcess {

	public static ArrayList<Produto> produtos;
	public static ProdutoDAO pd = new ProdutoDAO();
	
	// testadora
	public static void testes() {
		produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Notebook", "Alta tecnologia", 1000, 2));
		produtos.add(new Produto(2, "Impressora", "Cartuchos e Scanners", 3000, 3));
		produtos.add(new Produto(3, "Smartphone", "Sistema único", 2800,1));
		produtos.add(new Produto(4, "Teclado", "Multicolorido",260, 4));
	}
	
	// abrir arquivo
	public static void abrir() {
		produtos = pd.abrir();
	}
	
	// gravar arquivo
	public static void salvar() {
		pd.salvar(produtos);
	}
	
	
}
