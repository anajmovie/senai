package servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
<<<<<<< HEAD
=======

>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
import controller.ProdutoProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet("/produtos")
public class ProdutoREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		ProdutoProcess.testes();
		
		// recebendo dados por parâmetro
		String id = req.getParameter("idProduto");
		if(id != null) {
			if(ProdutoProcess.produtos.contains(new Produto(id))) {
				int ind = ProdutoProcess.produtos.indexOf(new Produto(id)); // obtem o indice
				resp.getWriter().print(ProdutoProcess.produtos.get(ind).toJSON()); // nos da a resposta em formato json
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			JSONArray ja = new JSONArray(); // armazena cada objeto json
			ProdutoProcess.produtos.forEach(p -> ja.put(p.toJSON())); // percorre preenchendo o vetor com dados da lista
			resp.getWriter().print(ja); // resposta, mostra o vetor json
		}
	}
	
<<<<<<< HEAD
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		ProdutoProcess.testes();
		
		String id = req.getParameter("idProduto");
		if(id != null) {
			if(ProdutoProcess.produtos.contains(new Produto(id))) {
				int ind = ProdutoProcess.produtos.indexOf(new Produto(id));
				ProdutoProcess.produtos.remove(ind);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
	
	// create
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
=======
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
		ProdutoProcess.testes();
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			JSONObject json = new JSONObject(body);
<<<<<<< HEAD
			String nome = json.getString("nome");
			String descricao = json.getString("descricao");
			String preco = json.getString("preco");
			
			ProdutoProcess.produtos.add(new Produto(nome, descricao, preco));
			resp.setStatus(HttpServletResponse.SC_CREATED);
		} catch (JSONException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}			
=======
			int id = json.getInt("idProduto");
			String nome = json.getString("nome");
			String descricao = json.getString("descricao");
			double preco = json.getDouble("preco");
			
			ProdutoProcess.produtos.add(new Produto(id, nome, descricao, preco));
			resp.setStatus(HttpServletResponse.SC_CREATED);
		}catch(JSONException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
	}
}