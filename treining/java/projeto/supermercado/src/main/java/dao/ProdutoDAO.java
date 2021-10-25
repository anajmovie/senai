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
	private ResultSet rs;
	private Produto produto;
	private ArrayList<Produto> produtos;
	private ResultSet rs;
	
	
	// listando todos
	public ArrayList<Produto> readAll() throws SQLException{
		produtos = new ArrayList<>();
		String query = "select * from produtos;";
		// conecta, executa, e retorna os dados
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery(); // resultado
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
	
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
	// deletando pelo id
	public boolean delete(String idProduto) throws SQLException {
		String sql = "delete from produtos where id = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(idProduto));
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
	
<<<<<<< Updated upstream
=======
>>>>>>> 1c5afc4e6cdaacd2b3e543738df9b3aed5458303
>>>>>>> Stashed changes
	// criando um novo
	public int create(Produto produto) throws SQLException {
		String sql = "insert into produtos(nome, descricao, preco) values (?, ?, ?);";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, produto.getNome());
		ps.setString(2, produto.getDescricao());
		ps.setDouble(3, produto.getPreco());
		if(ps.executeUpdate() > 0) {
			rs = ps.getGeneratedKeys();
			rs.next();
			con.close();
			return rs.getInt(1);
		}else {
			return 0;
		}
	}
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	
	// deletando pelo id
	public boolean delete(String idProduto) throws SQLException {
		String sql = "delete from produtos where id_produto = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(idProduto));
		if(ps.executeUpdate() > 0) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	}
=======
>>>>>>> 1c5afc4e6cdaacd2b3e543738df9b3aed5458303
>>>>>>> Stashed changes
}