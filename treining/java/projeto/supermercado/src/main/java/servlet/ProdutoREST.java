package servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
		resp.setCharacterEncoding("utf8"); // configura��o do charset
		
		ProdutoProcess.testes();
		
		// recebendo dados por par�metro
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
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configura��o do charset
		
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
		resp.setCharacterEncoding("utf8"); // configura��o do charset
		
		ProdutoProcess.testes();
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			JSONObject json = new JSONObject(body);
			String nome = json.getString("nome");
			String descricao = json.getString("descricao");
			String preco = json.getString("preco");
			
			ProdutoProcess.produtos.add(new Produto(nome, descricao, preco));
			resp.setStatus(HttpServletResponse.SC_CREATED);
		} catch (JSONException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}			
	}
}