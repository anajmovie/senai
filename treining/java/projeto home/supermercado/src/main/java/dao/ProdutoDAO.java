package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

public class ProdutoDAO {
	// atributos principais
	private Connection con; // conexao
	private PreparedStatement ps; // envio
	private Produto produto;
	private ArrayList<Produto> produtos;
	
	// listando todos
	public ArrayList<Produto> readAll() throws SQLException{
		produtos = new ArrayList<>();
		String query = "select * from produtos;";
		// conecta, executa, e retorna os dados
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery(); // resultado
		while(rs.next()) { // percorre o resultado preenchendo a lista
			produto = new Produto();
			produto.setidProduto(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setPreco(rs.getDouble("preco"));
			produtos.add(produto);
		}
		con.close();
		return produtos;
	}
}